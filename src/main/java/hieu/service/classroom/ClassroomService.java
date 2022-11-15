package hieu.service.classroom;

import hieu.model.ClassRoom;
import hieu.repository.classroom.IClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassroomService implements IClassRoomService {

    @Autowired
    private IClassRoomRepository categoryRepository;

    @Override
    public List<ClassRoom> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public ClassRoom findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void save(ClassRoom classRoom) {
        categoryRepository.save(classRoom);
    }

    @Override
    public void delete(Long id) {
        categoryRepository.delete(id);
    }

    @Override
    public List<ClassRoom> findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
