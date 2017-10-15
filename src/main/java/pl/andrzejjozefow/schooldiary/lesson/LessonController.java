package pl.andrzejjozefow.schooldiary.lesson;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LessonController {

  private final LessonService lessonService;

  public LessonController(LessonService lessonService) {
    this.lessonService = lessonService;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/lessons")
  public void addLesson(@RequestBody Lesson lesson) {
    lessonService.addLesson(lesson);
  }

  @RequestMapping("/lessons")
  public List<Lesson> getAllLessons() {
    return lessonService.getAllLessons();
  }
}
