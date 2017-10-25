package pl.andrzejjozefow.schooldiary;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.andrzejjozefow.schooldiary.student.StudentService;


@Controller
public class TestController {

  private final StudentService studentService;

  public TestController(StudentService studentService) {
    this.studentService = studentService;
  }


  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    model.put("message", "Siema");
    model.put("someone", new Person("Janusz", "Cebulak"));

    List<Person> friends = Arrays.asList(
        new Person("Andrzej", "Józefów"),
        new Person("Jakub", "Sprega"),
        new Person("Gosia", "Sprega")
    );

    model.put("friends", friends);

    return "welcome";
  }

  @RequestMapping("/thebeatles")
  public String beatles(Map<String, Object> model) {
    model.put("beatles", studentService.getAllStudents());

    return "students";
  }

  static class Person {
    public String name;
    public String surname;

    public Person(String name, String surname) {
      this.name = name;
      this.surname = surname;
    }

    public String getName() {
      return name;
    }

    public String getSurname() {
      return surname;
    }
  }

}
