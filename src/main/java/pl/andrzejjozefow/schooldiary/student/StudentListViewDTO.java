package pl.andrzejjozefow.schooldiary.student;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.model.BaseDTO;

@Getter
public class StudentListViewDTO extends BaseDTO {

  private final String studentFirstName;
  private final String studentLastName;

  public StudentListViewDTO(final Student student) {
    super(student.getId());
    this.studentFirstName = student.getFirstName();
    this.studentLastName = student.getLastName();
  }

  public static List<StudentListViewDTO> from(final List<Student> students){
    return students.stream()
        .map(StudentListViewDTO::new)
        .collect(Collectors.toList());
  }
}