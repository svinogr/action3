package ap.dao.daoImpl;

import ap.dao.BasicDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.osgi.service.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BasicDaoImpl<T> implements BasicDao<T> {
    @Autowired
    SessionFactory sessionFactory;

    private Class<T> type;

    public BasicDaoImpl(Class<T> type) {
        this.type = type;
    }

    public BasicDaoImpl() {
    }

    @Transactional
    public T getById(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.get(type, id);
        return currentSession.get(type, id);
    }

    @Transactional
    public T save(T object) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(object);
        return object;
    }

    @Transactional
    public T update(T object) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(object);
        return object;
    }

    @Transactional
    public boolean delete(T object) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.delete(object);
        return true;
    }
}
