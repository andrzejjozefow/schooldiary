package pl.andrzejjozefow.schooldiary.lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import pl.andrzejjozefow.schooldiary.student.Student;

@Entity
@Table(name = "LESSON")
public class Lesson {

  @Id
  @GeneratedValue
  @Column(name = "LESSON_ID")
  private Integer lessonId;

  @Column(name = "STUDENT_ID")
  private Integer studentId;

  @Column(name = "LESSON_SUBJECT")
  @NotEmpty
  private String subject;

  public Lesson() {
  }

  public Lesson(Integer studentId, String subject) {
    this.studentId = studentId;
    this.subject = subject;
  }

  public Lesson(Integer lessonId, Student student, String subject) {
    this.lessonId = lessonId;
    this.studentId = studentId;
    this.subject = subject;

  }

  public Integer getLessonId() {
    return lessonId;
  }

  public void setLessonId(Integer lessonId) {
    this.lessonId = lessonId;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public Integer getStudentId() {
    return studentId;
  }
}
