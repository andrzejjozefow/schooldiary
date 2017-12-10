package pl.andrzejjozefow.schooldiary.lesson.dto;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Getter
public class LessonListViewDTO {

    private final Integer lessonId;
    private final String lessonSubject;
    private final Date lessonDate;
    private final String studentFirstName;
    private final String studentLastName;

    public LessonListViewDTO(final Lesson lesson) {
        this.lessonId = lesson.getId();
        this.lessonSubject = lesson.getSubject();
        this.lessonDate = lesson.getDate();
        this.studentFirstName = lesson.getStudent().getFirstName();
        this.studentLastName = lesson.getStudent().getLastName();
    }

    public static List<LessonListViewDTO> from(final Collection<Lesson> lessons) {
        return lessons.stream()
            .map(LessonListViewDTO::new)
            .collect(Collectors.toList());
    }
}
