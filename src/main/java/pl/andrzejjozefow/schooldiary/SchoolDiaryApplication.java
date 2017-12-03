package pl.andrzejjozefow.schooldiary;


import java.util.Date;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.lesson.LessonRepository;
import pl.andrzejjozefow.schooldiary.student.ContactDetails.ContactDetails;
import pl.andrzejjozefow.schooldiary.student.ContactDetails.ContactDetailsRepository;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

@SpringBootApplication
public class SchoolDiaryApplication {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private LessonRepository lessonRepository;

  @Autowired
  private ContactDetailsRepository contactDetailsRepository;

  public static void main(String[] args) {
    SpringApplication.run(SchoolDiaryApplication.class, args);
  }

  @PostConstruct
  public void initData() {
    ContactDetails contactDetails = new ContactDetails(null, "asdfg@wp.pl", "123", "dsadas", "dasda", "dasda", "dsadsa");

    Student jakub = new Student("Jakub","Spręga", new Date(), contactDetails, null);
    studentRepository.save(jakub);

    contactDetails.setStudent(jakub);
    contactDetailsRepository.save(contactDetails);


    Lesson lesson = new Lesson();
    lesson.setSubject("Gitara");
    lesson.setStudent(jakub);
    lessonRepository.save(lesson);
    //studentRepository.save(new Student("Andrzej", "Józefów"));
//
    Set<Lesson> lessons = studentRepository.findById(jakub.getId()).getLessons();
    //System.out.println(lesson);

  }

}