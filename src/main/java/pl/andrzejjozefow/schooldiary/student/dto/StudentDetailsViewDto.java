package pl.andrzejjozefow.schooldiary.student.dto;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import pl.andrzejjozefow.schooldiary.lesson.dto.LessonDto;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
public class StudentDetailsViewDto {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final Date birthDate;
    private final String email;
    private final String phone;
    private final String street;
    private final String city;
    private final String zipCode;
    private final String country;
    private final Double avgScore;
    private final List<LessonDto> lessonsDto;


    public StudentDetailsViewDto(final Student student, final Double avgScore) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.birthDate = student.getBirthDate();
        this.email = student.getEmail();
        this.phone = student.getPhoneNumber();
        this.street = student.getStreet();
        this.city = student.getCity();
        this.zipCode = student.getZipCode();
        this.country = student.getCountry();
        this.avgScore = avgScore;
        this.lessonsDto = LessonDto.from(student.getLessons());
    }

}
