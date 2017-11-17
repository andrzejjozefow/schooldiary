package pl.andrzejjozefow.schooldiary.lesson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;
import pl.andrzejjozefow.schooldiary.student.Student;

@Entity
public class Lesson {

  @Id
  @GeneratedValue
  @Column
  private Integer id;

  @ManyToOne
  @JoinColumn
  private Student student;

  @NotEmpty
  private String subject;


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Student getStudent() {
    return student;
  }
}
