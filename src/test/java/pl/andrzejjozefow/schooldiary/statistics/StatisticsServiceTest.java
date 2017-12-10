package pl.andrzejjozefow.schooldiary.statistics;

import static org.junit.Assert.*;

import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.student.ContactDetails.ContactDetails;
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
    Set<Lesson> lessons = ImmutableSet.of(
        new Lesson(null, "technika gamowa", new Date(), 5),
        new Lesson(null, "technika gamowa", new Date(), 4),
        new Lesson(null, "technika gamowa", new Date(), 2)
    );
    Student student = new Student("jan","nowak", new Date(), new ContactDetails(), lessons);
    given(studentRepository.findOne(anyInt())).willReturn(student);

    //when
    Double studentAvgScore = statisticsService.getStudentAvgScore(1);

    //then
    assertThat(studentAvgScore).isCloseTo(3.66, within(0.1));
  }

  @Test
  public void shouldCalculateAvgScoreOnStudentWithoutLessons()  {
    Student studentWithoutLessons = new Student("jan","nowak", new Date(), new ContactDetails(), Collections.emptySet());
    given(studentRepository.findOne(anyInt())).willReturn(studentWithoutLessons);

    //when
    Double studentAvgScore = statisticsService.getStudentAvgScore(1);

    //then
    assertThat(studentAvgScore).isEqualTo(0);
  }

}