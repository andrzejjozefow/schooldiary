package pl.andrzejjozefow.schooldiary.lesson;
import pl.andrzejjozefow.schooldiary.student.StudentViewDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LessonViewDTO {

    Integer id;

    StudentViewDTO studentViewDTO;

    String subject;


    public LessonViewDTO(Integer id, StudentViewDTO studentViewDTO, String subject) {

        this.id = id;
        this.studentViewDTO = studentViewDTO;
        this.subject = subject;
    }


    public static LessonViewDTO mapFromLessonEntity(Lesson lesson) {
        return new LessonViewDTO(lesson.getId(), StudentViewDTO.mapFromStudentEntity(lesson.getStudent()), lesson.getSubject());
    }

    public static Set<LessonViewDTO> mapFromLessonsEntities(List<Lesson> lessons) {
        return lessons.stream().map((lesson) -> mapFromLessonEntity(lesson)).collect(Collectors.toSet());
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
