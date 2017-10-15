package pl.andrzejjozefow.schooldiary.student;

import java.util.List;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  @RequestMapping(method = RequestMethod.POST, value = "/students")
  public void addLesson(@RequestBody Student student) {
    studentService.addStudent(student);
  }

  @RequestMapping("/students")
  public List<Student> getAllStudents() {
    return studentService.getAllStudents();
  }
}
