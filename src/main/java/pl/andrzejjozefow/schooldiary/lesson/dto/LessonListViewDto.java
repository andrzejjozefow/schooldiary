package pl.andrzejjozefow.schooldiary.lesson.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Getter
public class LessonListViewDto {

    private final Integer id;
    private final String subject;
    private final Date date;
    private final String firstName;
    private final String lastName;
    private final Integer score;

    public LessonListViewDto(final Lesson lesson) {
        this.id = lesson.getId();
        this.subject = lesson.getSubject();
        this.date = lesson.getDate();
        this.firstName = lesson.getStudent().getFirstName();
        this.lastName = lesson.getStudent().getLastName();
        this.score = lesson.getScore();
    }

    public static List<LessonListViewDto> from(final Collection<Lesson> lessons) {
        return lessons.stream()
            .map(LessonListViewDto::new)
            .collect(Collectors.toList());
    }
}
