package pl.andrzejjozefow.schooldiary.student;

import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.lesson.LessonViewDTO;
import pl.andrzejjozefow.schooldiary.model.BaseDTO;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StudentViewDTO extends BaseDTO{

    String name;

    Set<LessonViewDTO> lessonViewDTOSet;

    public StudentViewDTO(Integer id, String name, List<Lesson> lessons) {

    }

    public static StudentViewDTO mapFromStudentEntity(Student student) {
        return new StudentViewDTO(student.getId(), student.getName(), student.getLessons());
    }

    public static List<StudentViewDTO> mapFromStudentsEntities(List<Student> students) {
        return students.stream().map((student) -> mapFromStudentEntity(student)).collect(Collectors.toList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<LessonViewDTO> getLessonViewDTOSet() {
        return lessonViewDTOSet;
    }

    public void setLessonViewDTOSet(Set<LessonViewDTO> lessonViewDTOSet) {
        this.lessonViewDTOSet = lessonViewDTOSet;
    }
}
