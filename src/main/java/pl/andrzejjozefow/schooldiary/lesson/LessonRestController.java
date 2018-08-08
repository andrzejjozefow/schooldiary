package pl.andrzejjozefow.schooldiary.lesson;

import static pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDto.from;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDto;

@RestController
public class LessonRestController {

    private final LessonService lessonService;

    public LessonRestController(final LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping("/lessons.json")
    public List<LessonListViewDto> lessons() {
        final List<Lesson> lessons = lessonService.getAllLessons();
        return from(lessons);
    }
}
