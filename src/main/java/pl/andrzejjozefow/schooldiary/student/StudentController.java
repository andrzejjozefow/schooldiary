package pl.andrzejjozefow.schooldiary.student;

import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("STUDENT_ID");
  }

  @RequestMapping(value = "/students/new", method = RequestMethod.GET)
  public String initCreationForm(Map<String, Object> model) {
    Student student = new Student();
    model.put("student", student);
    return "createOrUpdateStudentForm";
  }

  @RequestMapping(value = "/students/new", method = RequestMethod.POST)
  public String processCreationForm(@Valid Student student, BindingResult result) {
    if (result.hasErrors()) {
      return "createOrUpdateStudentForm";
    } else {
      this.studentService.addStudent(student);
      return "redirect:/students/";
    }
  }

  @RequestMapping("/students")
  public String students(Map<String, Object> model) {
    model.put("student", studentService.getAllStudents());

    return "studentsList";
  }

}
