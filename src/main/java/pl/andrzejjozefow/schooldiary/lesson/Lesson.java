package pl.andrzejjozefow.schooldiary.lesson;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;
import pl.andrzejjozefow.schooldiary.student.Student;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Lesson extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @NotEmpty
    private String subject;

    private Date date;

    @Range(min = 0, max = 5, message = "Score should be between 0 and 5")
    private Integer score;

}
