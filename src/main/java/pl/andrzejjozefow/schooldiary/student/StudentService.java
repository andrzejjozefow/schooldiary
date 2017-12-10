package pl.andrzejjozefow.schooldiary.student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(final StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void addStudent(final Student student) {
        studentRepository.save(student);
    }

    public Optional<Student> getStudent(final Integer id) {
        return Optional.ofNullable(studentRepository.findOne(id));
    }

    public List<Student> getAllStudents() {
        final List<Student> students = new ArrayList<>();
        studentRepository.findAll().forEach(students::add);
        return students;
    }

    public Student findById(final Integer id) {
        return studentRepository.findOne(id);
    }
}
