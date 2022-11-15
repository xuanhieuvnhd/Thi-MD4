package hieu.repository.student;

import hieu.model.Student;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ClassRoomRepository implements IClassRoomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("Select p from Student as p", Student.class);
        return query.getResultList();
    }

    @Override
    public Student findById(Long id) {
        TypedQuery<Student> query = em.createQuery("Select p from Student as p where p.id = :id", Student.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Student student) {
            if (student.getId() == null) {
                em.persist(student);
            }else {
                em.merge(student);
            }
    }

    @Override
    public void delete(Long id) {
        Student student = this.findById(id);
        em.remove(student);
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student> query = em.createQuery("Select p from Student as p where p.name like :name", Student.class);
        query.setParameter("name", name);
        return query.getResultList();
    }
}
