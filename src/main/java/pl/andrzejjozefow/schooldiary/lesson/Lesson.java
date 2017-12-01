package pl.andrzejjozefow.schooldiary.lesson;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;
import pl.andrzejjozefow.schooldiary.student.Student;


@Entity
@Data
@NoArgsConstructor
public class Lesson extends BaseEntity {


  @ManyToOne
  @JoinColumn(name = "student_id")
  private Student student;

  @NotEmpty
  private String subject;

  
}
