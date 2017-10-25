package pl.andrzejjozefow.schooldiary;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

@SpringBootApplication
public class SchoolDiaryApplication {

  @Autowired
  private StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(SchoolDiaryApplication.class, args);
  }

  @PostConstruct
  public void initDatabase(){
    studentRepository.save(new Student("Paul"));
    studentRepository.save(new Student("Ringo"));
    studentRepository.save(new Student("John"));

    Iterable<Student> students = studentRepository.findAll();

    for(Student singleStudent : students){
      System.out.println(singleStudent);
    }

    System.out.println("Students: " + students);
  }
}

