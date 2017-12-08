package pl.andrzejjozefow.schooldiary.student;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;

@Getter
public class StudentListViewDTO {

  private final Integer studentId;
  private final String studentFirstName;
  private final String studentLastName;
  private final String studentEmail;
  private final String studentPhone;

  public StudentListViewDTO(final Student student) {
    this.studentId = student.getId();
    this.studentFirstName = student.getFirstName();
    this.studentLastName = student.getLastName();
    this.studentEmail = student.getContactDetails().getEmail();
    this.studentPhone = student.getContactDetails().getPhoneNumber();
  }

  public static List<StudentListViewDTO> from(final List<Student> students){
    return students.stream()
        .map(StudentListViewDTO::new)
        .collect(Collectors.toList());
  }
}