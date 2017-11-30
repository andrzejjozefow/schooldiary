package pl.andrzejjozefow.schooldiary.lesson;


import lombok.Getter;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class CreateLessonViewDTO {

  private final Integer studentId;
  private final String studentName;

  public CreateLessonViewDTO(final Student student) {
    this.studentId = student.getId();
    this.studentName = student.getName();
  }
}
