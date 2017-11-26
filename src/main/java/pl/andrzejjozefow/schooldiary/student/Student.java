package pl.andrzejjozefow.schooldiary.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;

@Entity
public class Student extends BaseEntity {

  private String name;

  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
  private Set<Lesson> lessons = new LinkedHashSet<>();

  public Student() {
  }

  public Student(String name) {
    this.name = name;
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

  public Set<Lesson> getLessons() {
    return lessons;
//    List<Lesson> sortedLessons = new ArrayList<>(getLessonsInternal());
//    PropertyComparator.sort(sortedLessons,
//        new MutableSortDefinition("id", false, false));
//    return Collections.unmodifiableList(sortedLessons);
  }

  public void addLesson(Lesson lesson) {
    getLessonsInternal().add(lesson);
    lesson.setStudent(this);
  }

}
