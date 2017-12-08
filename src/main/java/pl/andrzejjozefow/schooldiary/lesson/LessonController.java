package pl.andrzejjozefow.schooldiary.lesson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.andrzejjozefow.schooldiary.lesson.dto.CreateLessonViewDTO;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonDTO;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDTO;
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
    Optional<Student> student = Optional.ofNullable(studentService.getStudent(studentId));
    if (student.isPresent()) {
      CreateLessonViewDTO createLessonViewDTO = new CreateLessonViewDTO(student);
      model.put("student", createLessonViewDTO);
      model.put("lesson", new Lesson());
      return "/lesson/createOrUpdateLessonForm";
    } else {
      return "welcome";
    }


  }

  @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.POST)
  public String processNewLessonForm(@PathVariable("studentId") Student student,
      @Valid Lesson lesson, BindingResult result, Map<String, Object> model) {
    CreateLessonViewDTO createLessonViewDTO = new CreateLessonViewDTO(Optional.ofNullable(student));
    model.put("student", createLessonViewDTO);
    if (result.hasErrors()) {
      return "/lesson/createOrUpdateLessonForm";
    } else {
      lesson.setStudent(student);
      lesson.setDate(new Date());
      this.lessonService.addLesson(lesson);
      return "redirect:/students/{studentId}";
    }
  }

  @RequestMapping("/lessons")
  public String lessons(Map<String, Object> model) {
    List<Lesson> lessons = lessonService.getAllLessons();
    List<LessonListViewDTO> lessonsListViewDTO = LessonListViewDTO.from(lessons);
    model.put("lessons", lessonsListViewDTO);
    return "/lesson/lessonList";
  }
}
