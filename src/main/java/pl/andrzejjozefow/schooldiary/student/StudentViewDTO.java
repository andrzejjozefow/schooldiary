package pl.andrzejjozefow.schooldiary.student;

import org.springframework.beans.support.MutableSortDefinition;
import org.springframework.beans.support.PropertyComparator;
import pl.andrzejjozefow.schooldiary.lesson.Lesson;
import pl.andrzejjozefow.schooldiary.lesson.LessonViewDTO;
import pl.andrzejjozefow.schooldiary.model.BaseDTO;

import java.util.*;
import java.util.stream.Collectors;

public class StudentViewDTO {

    Integer id;

    String name;

    Set<LessonViewDTO> lessonViewDTOSet;


    public StudentViewDTO(Integer id, String name, Set<LessonViewDTO> lessonViewDTOSet) {

        this.id = id;
        this.name = name;
        this.lessonViewDTOSet = lessonViewDTOSet;

    }

    public static StudentViewDTO mapFromStudentEntity(Student student) {
        return new StudentViewDTO(student.getId(), student.getName(), LessonViewDTO.mapFromLessonsEntities(student.getLessons()));
    }

    public static List<StudentViewDTO> mapFromStudentsEntities(List<Student> students) {
        return students.stream().map((student) -> mapFromStudentEntity(student)).collect(Collectors.toList());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Set<LessonViewDTO> getLessonsInternal() {
        if (this.lessonViewDTOSet == null) {
            this.lessonViewDTOSet = new HashSet<>();
        }
        return this.lessonViewDTOSet;
    }

    protected void setLessonsInternal(Set<LessonViewDTO> lessonViewDTOSet) {

        this.lessonViewDTOSet = lessonViewDTOSet;
    }

    public List<LessonViewDTO> getLessons() {
        List<LessonViewDTO> sortedLessons = new ArrayList<>(getLessonsInternal());
        PropertyComparator.sort(sortedLessons,
                new MutableSortDefinition("id", false, false));
        return Collections.unmodifiableList(sortedLessons);
    }

    public void addLesson(LessonViewDTO lessonViewDTO) {
        getLessonsInternal().add(lessonViewDTO);
        lessonViewDTO.setStudentViewDTO(this);
    }


}
