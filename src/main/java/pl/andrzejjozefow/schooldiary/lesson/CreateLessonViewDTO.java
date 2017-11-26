package pl.andrzejjozefow.schooldiary.lesson;


import pl.andrzejjozefow.schooldiary.student.Student;

public class CreateLessonViewDTO {

  private final Integer studentId;
  private final String studentName;

  public CreateLessonViewDTO(final Student student) {
    this.studentId = student.getId();
    this.studentName = student.getName();
  }

  public Integer getStudentId() {
    return studentId;
  }

  public String getStudentName() {
    return studentName;
  }
}
