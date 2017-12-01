package pl.andrzejjozefow.schooldiary.lesson;


import lombok.Getter;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class CreateLessonViewDTO {

  private final Integer studentId;
  private final String studentFirstName;
  private final String studentLastName;

  public CreateLessonViewDTO(final Student student) {
    this.studentId = student.getId();
    this.studentFirstName = student.getFirstName();
    this.studentLastName = student.getLastName();
  }
}
