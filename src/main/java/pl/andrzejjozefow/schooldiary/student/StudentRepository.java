package pl.andrzejjozefow.schooldiary.student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface StudentRepository extends CrudRepository <Student, Integer>  {

  @Transactional(readOnly = true)
  Student findById(Integer id);

}
