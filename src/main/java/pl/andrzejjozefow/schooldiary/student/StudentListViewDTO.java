package pl.andrzejjozefow.schooldiary.student;
import java.util.List;
import java.util.stream.Collectors;
import pl.andrzejjozefow.schooldiary.model.BaseDTO;

public class StudentListViewDTO extends BaseDTO {

  private final String name;

  public StudentListViewDTO(final Student student) {
    super(student.getId());
    this.name = student.getName();
  }

  public String getName() {
    return name;
  }

  public static List<StudentListViewDTO> from(final List<Student> students){
    return students.stream()
        .map(StudentListViewDTO::new)
        .collect(Collectors.toList());
  }
}