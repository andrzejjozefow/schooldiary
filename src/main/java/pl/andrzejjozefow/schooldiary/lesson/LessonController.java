package pl.andrzejjozefow.schooldiary.lesson;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.andrzejjozefow.schooldiary.lesson.dto.CreateLessonViewDto;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDto;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentService;

@RequiredArgsConstructor
@Controller
public class LessonController {

    private final LessonService lessonService;
    private final StudentService studentService;

    @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.GET)
    public String initNewLessonForm(@PathVariable("studentId") final Integer studentId,
        final Map<String, Object> model) {
        final Optional<Student> student = studentService.getStudent(studentId);
        if (student.isPresent()) {
            final CreateLessonViewDto createLessonViewDto = new CreateLessonViewDto(student.get());
            model.put("student", createLessonViewDto);
            model.put("lesson", new Lesson());
            return "/lesson/createOrUpdateLessonForm";
        } else {
            return "welcome";
        }
    }

    @RequestMapping(value = "students/{studentId}/lessons/new", method = RequestMethod.POST)
    public String processNewLessonForm(@PathVariable("studentId") final Student student,
        @Valid final Lesson lesson, final BindingResult result, final Map<String, Object> model) {
        final CreateLessonViewDto createLessonViewDto = new CreateLessonViewDto(student);
        model.put("student", createLessonViewDto);
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
    public String lessons(final Map<String, Object> model) {
        final List<Lesson> lessons = lessonService.getAllLessons();
        final List<LessonListViewDto> lessonsListViewDto = LessonListViewDto.from(lessons);
        model.put("lessons", lessonsListViewDto);
        return "/lesson/lessonList";
    }
}
