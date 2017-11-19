package pl.andrzejjozefow.schooldiary.lesson;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LessonService {

  private final LessonRepository lessonRepository;

  public LessonService(LessonRepository lessonRepository) {
    this.lessonRepository = lessonRepository;
  }

  public void addLesson(Lesson lesson) {
    lessonRepository.save(lesson);
  }

  public Lesson getLesson(Integer id) {
    return lessonRepository.findOne(id);
  }

  public List<Lesson> getAllLessons() {
    List<Lesson> lessons = new ArrayList<>();
    lessonRepository.findAll().forEach(lessons::add);
    return lessons;

  }
}