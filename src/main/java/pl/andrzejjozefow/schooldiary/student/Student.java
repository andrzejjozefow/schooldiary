package pl.andrzejjozefow.schooldiary.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Entity
public class Student {

  @Id
  @GeneratedValue
  private Integer id;

  private String name;

  @OneToMany
  @JoinColumn
  private Set<Lesson> lessons = new LinkedHashSet<>();



  public Integer getId() {
    return id;
  }

  public void setId(Integer studentId) {
    this.id = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  protected Set<Lesson> getLessonsInternal() {
    if (this.lessons == null) {
      this.lessons = new HashSet<>();
    }
    return this.lessons;
  }

  protected void setLessonsInternal(Set<Lesson> lessons) {
    this.lessons = lessons;
  }

  public List<Lesson> getLessons() {
    List<Lesson> sortedLessons = new ArrayList<>(getLessonsInternal());
    PropertyComparator.sort(sortedLessons,
        new MutableSortDefinition("id", false, false));
    return Collections.unmodifiableList(sortedLessons);
  }

  public void addLesson(Lesson lesson) {
    getLessonsInternal().add(lesson);
    lesson.setStudent(this);
  }

}
