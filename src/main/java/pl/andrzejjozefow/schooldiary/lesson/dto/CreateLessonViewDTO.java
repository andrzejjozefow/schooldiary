package pl.andrzejjozefow.schooldiary.lesson.dto;


import java.util.Optional;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class CreateLessonViewDTO {

  private final Integer studentId;
  private final String studentFirstName;
  private final String studentLastName;

  public CreateLessonViewDTO(final Optional<Student> student) {
    this.studentId = student.get().getId();
    this.studentFirstName = student.get().getFirstName();
    this.studentLastName = student.get().getLastName();
  }
}
