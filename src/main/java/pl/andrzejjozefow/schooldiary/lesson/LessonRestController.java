package pl.andrzejjozefow.schooldiary.lesson;

import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDto;

@RestController
public class LessonRestController {

    private final LessonService lessonService;

    public LessonRestController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping("/lessons.json")
    public List<LessonListViewDto> lessons(final Map<String, Object> model) {
        final List<Lesson> lessons = lessonService.getAllLessons();
        final List<LessonListViewDto> lessonsListViewDto = LessonListViewDto.from(lessons);
        return lessonsListViewDto;
    }
}
