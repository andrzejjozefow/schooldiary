package pl.andrzejjozefow.schooldiary.lesson;

import static pl.andrzejjozefow.schooldiary.lesson.dto.LessonListViewDto.from;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
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
    public List<LessonListViewDto> lessons(@AuthenticationPrincipal final UserDetails userDetails) {
        String userName = userDetails.getUsername();
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
        authorities.forEach(System.out::println);
        final List<Lesson> lessons = lessonService.getAllLessons();
        return from(lessons);
    }
}
