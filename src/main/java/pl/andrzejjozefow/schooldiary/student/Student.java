package pl.andrzejjozefow.schooldiary.student;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;

@Entity
@Data
@NoArgsConstructor
public class Student extends BaseEntity {

  private String firstName;
  private String lastName;

  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private Date birthDate;

  //podmieniłem typ z "Set" na "List" żeby lekcje wyświetlały się w kolejności (do sprawdzenia czy nie buguje zapytań)
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
  private List<Lesson> lessons = new ArrayList<>();

  public Student(String firstName, String lastName, Date birthDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
  }

  public List<Lesson> getLessons() {
    Collections.reverse(lessons);
    return lessons;
  }

  public void addLesson(Lesson lesson) {
    lessons.add(lesson);
    lesson.setStudent(this);
  }
}
