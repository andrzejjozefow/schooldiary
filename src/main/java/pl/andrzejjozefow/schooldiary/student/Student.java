package pl.andrzejjozefow.schooldiary.student;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends BaseEntity {

    private String firstName;

    private String lastName;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthDate;

    private String email;

    private String phoneNumber;

    private String street;

    private String city;

    private String zipCode;

    private String country;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private Set<Lesson> lessons = new LinkedHashSet<>();

    public void addLesson(final Lesson lesson) {
        lessons.add(lesson);
        lesson.setStudent(this);
    }

}
