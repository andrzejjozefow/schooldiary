package pl.andrzejjozefow.schooldiary.lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import pl.andrzejjozefow.schooldiary.student.Student;

@Entity
@Table(name = "LESSON")
public class Lesson {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "LESSON_ID")
  private Integer lessonId;

  @ManyToOne
  @JoinColumn(name = "STUDENT_ID")
  private Student student;

  @Column(name = "LESSON_SUBJECT")
  private String subject;


  public Lesson() {
  }

  public Lesson(Student student, String subject) {
    this.student = student;
    this.subject = subject;
  }

  public Lesson(Integer lessonId, Student student, String subject) {
    this.lessonId = lessonId;
    this.student = student;
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

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }
}
