package pl.andrzejjozefow.schooldiary.lesson.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Getter
public class LessonDto {

    private final Integer id;
    private final String subject;
    private final Date date;
    private final Integer score;

    public LessonDto(final Lesson lesson) {
        this.id = lesson.getId();
        this.subject = lesson.getSubject();
        this.date = lesson.getDate();
        this.score = lesson.getScore();
    }

    public static List<LessonDto> from(final Collection<Lesson> lessons) {
        return lessons.stream()
            .map(LessonDto::new)
            .collect(Collectors.toList());
    }
}
