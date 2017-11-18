package pl.andrzejjozefow.schooldiary.student;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

  private final StudentRepository studentRepository;

  public StudentService(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  public void addStudent(Student student) {
    studentRepository.save(student);
  }

  public Student getStudent(Integer id) {
    return studentRepository.findOne(id);
  }


  public List<Student> getAllStudents() {
    List<Student> students = new ArrayList<>();
    studentRepository.findAll().forEach(students::add);
    return students;
  }

  public Student findById(Student student) {
    return studentRepository.findById(student.getId());
  }
}
