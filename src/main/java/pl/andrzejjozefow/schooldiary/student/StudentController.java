package pl.andrzejjozefow.schooldiary.student;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.andrzejjozefow.schooldiary.statistics.StatisticsService;
import pl.andrzejjozefow.schooldiary.student.dto.StudentDetailsViewDto;
import pl.andrzejjozefow.schooldiary.student.dto.StudentListViewDto;

@RequiredArgsConstructor
@Controller
public class StudentController {

    private final StudentService studentService;
    private final StatisticsService statisticsService;

    @InitBinder
    public void setAllowedFields(final WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.GET)
    public String initCreationForm(final Map<String, Object> model) {
        model.put("student", new Student());
        return "/student/createOrUpdateStudentForm";
    }

    @RequestMapping(value = "/students/new", method = RequestMethod.POST)
    public String processCreationForm(@Valid final Student student, final BindingResult result) {
        if (result.hasErrors()) {
            return "/student/createOrUpdateStudentForm";
        } else {
            this.studentService.addStudent(student);
            return "redirect:/students/";
        }
    }

    @RequestMapping("/students")
    public String showStudents(final Map<String, Object> model) {
        final List<Student> students = studentService.getAllStudents();
        final List<StudentListViewDto> studentsListViewDto = StudentListViewDto.from(students);
        model.put("student", studentsListViewDto);
        return "/student/studentsList";
    }

    @RequestMapping("/students/{studentId}")
    public String showStudent(@PathVariable("studentId") final Integer studentId,
        final Map<String, Object> model) {
        final Optional<Student> student = studentService.getStudent(studentId);
        if (student.isPresent()) {
            final Double studentAvgScore = statisticsService.getStudentAvgScore(studentId);
            final StudentDetailsViewDto studentDetailsViewDto = new StudentDetailsViewDto(student.get(),studentAvgScore);
            model.put("student", studentDetailsViewDto);
            return "/student/studentDetails";
        } else {
            return "welcome";
        }
    }
}
