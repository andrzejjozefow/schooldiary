package pl.andrzejjozefow.schooldiary.student.ContactDetails;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.andrzejjozefow.schooldiary.model.BaseEntity;
import pl.andrzejjozefow.schooldiary.student.Student;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetails extends BaseEntity {

  @OneToOne
  @JoinColumn(name = "student_id")
  private Student student;

  private String email;

  private String phoneNumber;

  private String street;

  private String city;

  private String zipCode;

  private String country;
}
