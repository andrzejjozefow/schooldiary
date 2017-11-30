package pl.andrzejjozefow.schooldiary.student;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;

@Entity
@Getter @Setter
public class Student extends BaseEntity {

  private String name;

  //podmieniłem typ z Set na List żeby lekcje wyświetlały się w kolejności (do sprawdzenia)
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
  private List<Lesson> lessons = new ArrayList<>();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
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
