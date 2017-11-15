package pl.andrzejjozefow.schooldiary.lesson;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("STUDENT_ID", "LESSON_ID");
  }

  public void loadStudentWithLesson(int studentId, Lesson lesson, Map<String, Object> model) {
    Student student = this.studentService.findStudentById(studentId);
    model.put("student", student);
    student.addLesson(lesson);
    model.put("lesson", lesson);
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.GET)
  public String initNewVisitForm(@PathVariable("studentId") int studentId, Map<String, Object> model) {
    loadStudentWithLesson(studentId, new Lesson(), model);
    return "createOrUpdateLessonForm";
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.POST)
  public String processNewVisitForm(@PathVariable("studentId") int studentId, @Valid Lesson lesson, BindingResult result,Map<String, Object> model ) {
    loadStudentWithLesson(studentId, lesson, model);
    if (result.hasErrors()) {
      return "createOrUpdateLessonForm";
    } else {
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
