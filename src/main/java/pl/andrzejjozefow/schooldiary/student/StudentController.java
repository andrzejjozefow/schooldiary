package pl.andrzejjozefow.schooldiary.student;

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
import pl.andrzejjozefow.schooldiary.student.ContactDetails.ContactDetails;
import pl.andrzejjozefow.schooldiary.student.ContactDetails.ContactDetailsService;
import pl.andrzejjozefow.schooldiary.student.dto.StudentDetailsViewDTO;
import pl.andrzejjozefow.schooldiary.student.dto.StudentListViewDTO;

@Controller
public class StudentController {

  private final StudentService studentService;
  private final ContactDetailsService contactDetailsService;

  public StudentController(StudentService studentService,
      ContactDetailsService contactDetailsService) {
    this.studentService = studentService;
    this.contactDetailsService = contactDetailsService;
  }

  @InitBinder
  public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
  }

  @RequestMapping(value = "/students/new", method = RequestMethod.GET)
  public String initCreationForm(Map<String, Object> model) {
    Student student = new Student();
    ContactDetails contactDetails = new ContactDetails();
    model.put("student", student);
    model.put("contactdetails", contactDetails);
    return "createOrUpdateStudentForm";
  }

  @RequestMapping(value = "/students/new", method = RequestMethod.POST)
  public String processCreationForm(@Valid Student student, ContactDetails contactDetails, BindingResult result) {
    if (result.hasErrors()) {
      return "createOrUpdateStudentForm";
    } else {
      this.studentService.addStudent(student);
      contactDetails.setStudent(student);
      this.contactDetailsService.addContactDetails(contactDetails);
      return "redirect:/students/";
    }
  }

  @RequestMapping("/students")
  public String showStudents(Map<String, Object> model) {
    List<Student> students = studentService.getAllStudents();
    List<StudentListViewDTO> studentsListViewDTO = StudentListViewDTO.from(students);
    model.put("student", studentsListViewDTO);
    return "studentsList";
  }

  @RequestMapping("/students/{studentId}")
  public String showStudent(@PathVariable("studentId") Integer studentId, Map<String, Object> model) {
    Student student = studentService.getStudent(studentId);
    StudentDetailsViewDTO studentDetailsViewDTO = new StudentDetailsViewDTO(student);
    model.put("student", studentDetailsViewDTO);
    return "studentDetails";
  }
}
