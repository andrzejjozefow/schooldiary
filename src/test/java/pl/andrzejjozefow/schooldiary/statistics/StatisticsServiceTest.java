package pl.andrzejjozefow.schooldiary.statistics;

import com.google.common.collect.ImmutableSet;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StudentRepository.class, StatisticsService.class})
public class StatisticsServiceTest {

    @MockBean
    private StudentRepository studentRepository;

    @Autowired
    private StatisticsService statisticsService;

    @Test
    public void shouldCalculateAvgScore() {
        //given
        final Set<Lesson> lessons = ImmutableSet.of(
            new Lesson(null, "technika gamowa", new Date(), 5),
            new Lesson(null, "technika gamowa", new Date(), 4),
            new Lesson(null, "technika gamowa", new Date(), 2)
        );
        final Student student = new Student(
            "jan",
            "nowak",
            new Date(),
            "asdfg@wp.pl",
            "+123456789",
            "Kwiatowa 2",
            "Stare Pole",
            "12-345",
            "Polska", lessons);

        given(studentRepository.findOne(anyInt())).willReturn(student);

        //when
        final Double studentAvgScore = statisticsService.getStudentAvgScore(1);

        //then
        assertThat(studentAvgScore).isCloseTo(3.66, within(0.1));
    }

    @Test
    public void shouldCalculateAvgScoreOnStudentWithoutLessons() {
        final Student studentWithoutLessons = new Student("jan", "nowak", new Date(),
            "asdfg@wp.pl",
            "+123456789",
            "Kwiatowa 2",
            "Stare Pole",
            "12-345",
            "Polska", Collections.emptySet());

        given(studentRepository.findOne(anyInt())).willReturn(studentWithoutLessons);

        //when
        final Double studentAvgScore = statisticsService.getStudentAvgScore(1);

        //then
        assertThat(studentAvgScore).isEqualTo(0);
    }

}
