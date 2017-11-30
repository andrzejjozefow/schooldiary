package pl.andrzejjozefow.schooldiary.lesson;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;
import pl.andrzejjozefow.schooldiary.student.Student;


@Entity
@Getter @Setter
public class Lesson extends BaseEntity {


  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @NotEmpty
  private String subject;
  
}
