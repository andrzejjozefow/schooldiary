package pl.andrzejjozefow.schooldiary.lesson.dto;

import lombok.Getter;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class CreateLessonViewDto {

    private final Integer id;
    private final String firstName;
    private final String lastName;

    public CreateLessonViewDto(final Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
    }
}
