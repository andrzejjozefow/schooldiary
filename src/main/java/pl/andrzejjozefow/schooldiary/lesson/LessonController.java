package pl.andrzejjozefow.schooldiary.lesson;

import java.util.ArrayList;
import java.util.List;
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
import pl.andrzejjozefow.schooldiary.student.StudentViewDTO;

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
    dataBinder.setDisallowedFields("id");
  }

  public void loadStudentWithLesson(Student student, Lesson lesson, Map<String, Object> model) {
    student = studentService.findById(student);
    StudentViewDTO studentViewDTO = StudentViewDTO.mapFromStudentEntity(student);
    LessonViewDTO lessonViewDTO = LessonViewDTO.mapFromLessonEntity(lesson);
    model.put("student", studentViewDTO);
    studentViewDTO.addLesson(lessonViewDTO);
    model.put("lesson", lessonViewDTO);
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.GET)
  public String initNewLessonForm(@PathVariable("studentId") Student student,
      Map<String, Object> model) {
    loadStudentWithLesson(student, new Lesson(), model);
    return "createOrUpdateLessonForm";
  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.POST)
  public String processNewLessonForm(@PathVariable("studentId") Student student,
      @Valid Lesson lesson, BindingResult result, Map<String, Object> model) {
    loadStudentWithLesson(student, lesson, model);
    if (result.hasErrors()) {
      return "createOrUpdateLessonForm";
    } else {
      this.lessonService.addLesson(lesson);
      return "redirect:/students/{studentId}";
    }
  }

  @RequestMapping("/lessons")
  public String lessons(Map<String, Object> model) {
    List<LessonViewDTO> lessonViewDTOList = new ArrayList<>();
    lessonViewDTOList.addAll(LessonViewDTO.mapFromLessonsEntities(lessonService.getAllLessons())) ;
    model.put("lessons", lessonViewDTOList);

    return "lessonList";
  }
}
