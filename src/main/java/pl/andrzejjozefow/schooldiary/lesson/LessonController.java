package pl.andrzejjozefow.schooldiary.lesson;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentService;

@Controller
public class LessonController {

  private final LessonService lessonService;
  private final StudentService studentService;

  public LessonController(LessonService lessonService, StudentService studentService) {
    this.lessonService = lessonService;
    this.studentService = studentService;
  }

  public void loadStudentWithLesson(Student student, Lesson lesson, Map<String, Object> model) {
    model.put("student", student);
    student.addLesson(lesson);
    model.put("lesson", lesson);
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.GET)
  public String initNewLessonForm(@PathVariable("studentId") Integer studentId, Map<String, Object> model) {
    Student student = studentService.getStudent(studentId);
    model.put("student", student);
    model.put("lesson", new Lesson());
    return "createOrUpdateLessonForm";
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.POST)
  public String processNewLessonForm(@PathVariable("studentId") Student student,
      @Valid Lesson lesson, BindingResult result, Map<String, Object> model) {
    model.put("student", student);
    if (result.hasErrors()) {
      return "createOrUpdateLessonForm";
    } else {
      lesson.setStudent(student);
      this.lessonService.addLesson(lesson);
      return "redirect:/students/{studentId}";
    }
  }

  @RequestMapping("/lessons")
  public String lessons(Map<String, Object> model) {
    model.put("lessons", lessonService.getAllLessons());
    return "lessonList";
  }
}
