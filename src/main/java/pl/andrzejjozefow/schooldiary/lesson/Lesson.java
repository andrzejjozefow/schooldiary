package pl.andrzejjozefow.schooldiary.lesson;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.hibernate.validator.constraints.NotEmpty;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;
import pl.andrzejjozefow.schooldiary.student.Student;

@Entity
public class Lesson extends BaseEntity {

  @ManyToOne
  private Student student;

  @NotEmpty
  private String subject;


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
