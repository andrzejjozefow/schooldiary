package pl.andrzejjozefow.schooldiary.student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;

@Entity
@Table(name = "STUDENT")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "STUDENT_ID")
  private Integer studentId;

  @Column(name = "STUDENT_NAME")
  private String name;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "studentId", fetch = FetchType.EAGER)
  private Set<Lesson> lessons = new LinkedHashSet<>();


  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Student(Integer studentId, String name) {
    this.studentId = studentId;
    this.name = name;
  }

  public Integer getId() {
    return studentId;
  }

  public void setId(Integer studentId) {
    this.studentId = studentId;
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

  protected void setLessonsInternal(Set<Lesson> visits) {
    this.lessons = lessons;
  }

  public List<Lesson> getLessons() {
    List<Lesson> sortedVisits = new ArrayList<>(getLessonsInternal());
    PropertyComparator.sort(sortedVisits,
        new MutableSortDefinition("date", false, false));
    return Collections.unmodifiableList(sortedVisits);
  }

  public void addLesson(Lesson lesson) {
    getLessonsInternal().add(lesson);
    lesson.setStudentId(this.getId());
  }

}
