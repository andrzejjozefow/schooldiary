package pl.andrzejjozefow.schooldiary.statistics;

import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

@RequiredArgsConstructor
@Service
public class StatisticsService {

    private final StudentRepository studentRepository;

    public Double getStudentAvgScore(final Integer id) {
        final Set<Lesson> lessons = studentRepository.findOne(id).getLessons();
        return lessons.stream()
            .mapToInt(Lesson::getScore)
            .average()
            .orElse(0);
    }

}
