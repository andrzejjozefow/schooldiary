package pl.andrzejjozefow.schooldiary.student.dto;

import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class StudentListViewDto {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public StudentListViewDto(final Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.email = student.getEmail();
        this.phone = student.getPhoneNumber();
    }

    public static List<StudentListViewDto> from(final List<Student> students) {
        return students.stream()
            .map(StudentListViewDto::new)
            .collect(Collectors.toList());
    }
}
