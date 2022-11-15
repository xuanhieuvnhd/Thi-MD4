package hieu.repository.classroom;

import hieu.model.ClassRoom;
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
    public List<ClassRoom> findAll() {
        TypedQuery<ClassRoom> query = em.createQuery("SElect c from ClassRoom as c", ClassRoom.class);
        return query.getResultList();
    }

    @Override
    public ClassRoom findById(Long id) {
        TypedQuery<ClassRoom> query = em.createQuery("Select c from ClassRoom as c where c.id = :id", ClassRoom.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(ClassRoom classRoom) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<ClassRoom> findByName(String name) {
        return null;
    }
}
