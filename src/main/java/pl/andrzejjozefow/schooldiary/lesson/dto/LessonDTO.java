package pl.andrzejjozefow.schooldiary.lesson.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Getter
public class LessonDTO {

    private final Integer lessonId;
    private final String lessonSubject;
    private final Date lessonDate;
    private final Integer lessonScore;

    public LessonDTO(final Lesson lesson) {
        this.lessonId = lesson.getId();
        this.lessonSubject = lesson.getSubject();
        this.lessonDate = lesson.getDate();
        this.lessonScore = lesson.getScore();
    }

    public static List<LessonDTO> from(final Collection<Lesson> lessons) {
        return lessons.stream()
            .map(LessonDTO::new)
            .collect(Collectors.toList());
    }
}
