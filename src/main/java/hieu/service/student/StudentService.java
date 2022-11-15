package hieu.service.student;

import hieu.model.Student;
import hieu.repository.student.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentService implements IStudentService {

    @Autowired
    IClassRoomRepository studentRepository;
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepository.delete(id);
    }

    @Override
    public List<Student> findByName(String name) {
        name = "%" + name + "%";
        return studentRepository.findByName(name);
    }
}
