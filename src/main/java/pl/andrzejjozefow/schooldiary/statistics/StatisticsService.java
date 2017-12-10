package pl.andrzejjozefow.schooldiary.statistics;

import java.util.Optional;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

@RequiredArgsConstructor
public class StatisticsService {

  private final StudentRepository studentRepository;

  public Double getStudentAvgScore(final Integer id){
    Set<Lesson> lessons = studentRepository.findOne(id).getLessons();
    return lessons.stream()
        .mapToInt(Lesson::getScore)
        .average()
        .orElse(0);
  }

}
