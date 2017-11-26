package pl.andrzejjozefow.schooldiary;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.lesson.LessonRepository;
import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentRepository;

@SpringBootApplication
public class SchoolDiaryApplication {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private LessonRepository lessonRepository;

  public static void main(String[] args) {
    SpringApplication.run(SchoolDiaryApplication.class, args);
  }

  @PostConstruct
  public void initData() {
    Student jakub = new Student("Jakub");
    studentRepository.save(jakub);

    Lesson lesson = new Lesson();
    lesson.setSubject("Gitara");
    lesson.setStudent(jakub);
    lessonRepository.save(lesson);
    Student jakubFromDb = studentRepository.findOne(jakub.getId());
    System.out.println("Jakub from db:" + jakubFromDb);
    System.out.println("DUPA");
    studentRepository.save(new Student("Andrzej"));
  }

}