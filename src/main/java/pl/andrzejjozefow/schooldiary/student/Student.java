package pl.andrzejjozefow.schooldiary.student;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "STUDENT_ID")
  private Integer studentId;

  @Column(name = "STUDENT_NAME")
  private String name;


  public Student() {
  }

  public Student(String name) {
    this.name = name;
  }

  public Student(Integer studentId, String name) {
    this.studentId = studentId;
    this.name = name;
  }

  public Integer getStudentId() {
    return studentId;
  }

  public void setStudentId(Integer studentId) {
    this.studentId = studentId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
