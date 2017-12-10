package pl.andrzejjozefow.schooldiary;

import java.util.Date;
import java.util.Set;
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

    public static void main(final String[] args) {
        SpringApplication.run(SchoolDiaryApplication.class, args);
    }

    @PostConstruct
    public void initData() {

        final Student janNowak = new Student(
            "Jan",
            "Nowak",
            new Date(),
            "asdfg@wp.pl",
            "+123456789",
            "Kwiatowa 2",
            "Stare Pole",
            "12-345",
            "Polska",
            null
        );

        studentRepository.save(janNowak);
        final Lesson lesson = new Lesson();
        lesson.setSubject(
            "A.Tansman, 'Variationes sur un théme de Scriabine' - odczytywanie utworu, aplikatura");
        lesson.setDate(new Date());
        lesson.setScore(4);
        lesson.setStudent(janNowak);
        lessonRepository.save(lesson);
        final Set<Lesson> lessons = studentRepository.findOne(janNowak.getId()).getLessons();
    }
}
