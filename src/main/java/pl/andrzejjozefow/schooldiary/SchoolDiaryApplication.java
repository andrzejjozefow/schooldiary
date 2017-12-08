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
    ContactDetails contactDetails = new ContactDetails(
        null,
        "asdfg@wp.pl",
        "+123456789",
        "Kwiatowa 2",
        "Stare Pole",
        "12-345",
        "Polska");

    Student janNowak = new Student(
        "Jan",
        "Nowak",
        new Date(), contactDetails,
        null);

    studentRepository.save(janNowak);
    contactDetails.setStudent(janNowak);
    contactDetailsRepository.save(contactDetails);
    Lesson lesson = new Lesson();
    lesson.setSubject(
        "A.Tansman, 'Variationes sur un théme de Scriabine' - odczytywanie utworu, aplikatura");
    lesson.setDate(new Date());
    lesson.setStudent(janNowak);
    lessonRepository.save(lesson);
    Set<Lesson> lessons = studentRepository.findById(janNowak.getId()).getLessons();
  }
}