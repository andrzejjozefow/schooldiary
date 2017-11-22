package pl.andrzejjozefow.schooldiary.lesson;

import pl.andrzejjozefow.schooldiary.student.Student;
import pl.andrzejjozefow.schooldiary.student.StudentViewDTO;

import java.util.List;
import java.util.stream.Collectors;

public class LessonViewDTO {

    StudentViewDTO studentViewDTO;

    String subject;

    public LessonViewDTO(Integer id, String subject, Student student) {
    }

    public static LessonViewDTO mapFromLessonEntity(Lesson lesson) {
        return new LessonViewDTO(lesson.getId(), lesson.getSubject(), lesson.getStudent());
    }

    public static List<LessonViewDTO> mapFromLessonsEntities(List<Lesson> lessons) {
        return lessons.stream().map((lesson) -> mapFromLessonEntity(lesson)).collect(Collectors.toList());
    }

    public StudentViewDTO getStudentViewDTO() {

        return studentViewDTO;
    }

    public void setStudentViewDTO(StudentViewDTO studentViewDTO) {

        this.studentViewDTO = studentViewDTO;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {

        this.subject = subject;
    }
}
