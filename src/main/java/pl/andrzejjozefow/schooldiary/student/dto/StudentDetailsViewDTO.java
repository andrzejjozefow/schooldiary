package pl.andrzejjozefow.schooldiary.student.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonDTO;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class StudentDetailsViewDTO {

  private final Integer studentId;
  private final String studentFirstName;
  private final String studentLastName;
  private final Date studentBirthDate;
  private final String studentEmail;
  private final String studentPhone;
  private final String studentStreet;
  private final String studentCity;
  private final String studentZipCode;
  private final String studentCountry;
  private final List<LessonDTO> lessonsDTO;

  public StudentDetailsViewDTO(final Student student) {
    this.studentId = student.getId();
    this.studentFirstName = student.getFirstName();
    this.studentLastName = student.getLastName();
    this.studentBirthDate = student.getBirthDate();
    this.studentEmail = student.getContactDetails().getEmail();
    this.studentPhone = student.getContactDetails().getPhoneNumber();
    this.studentStreet = student.getContactDetails().getStreet();
    this.studentCity = student.getContactDetails().getCity();
    this.studentZipCode = student.getContactDetails().getZipCode();
    this.studentCountry = student.getContactDetails().getCountry();
    this.lessonsDTO = LessonDTO.from(student.getLessons());
  }

  public static List<StudentListViewDTO> from(final List<Student> students){
    return students.stream()
        .map(StudentListViewDTO::new)
        .collect(Collectors.toList());
  }
}