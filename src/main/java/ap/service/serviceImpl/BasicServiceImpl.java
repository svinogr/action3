package ap.service.serviceImpl;

import ap.dao.BasicDao;
import ap.service.BasicService;

public class BasicServiceImpl<T> implements BasicService<T> {

    protected BasicDao<T> dao;

    private Class<T> type;

    public BasicServiceImpl(Class<T> type) {
        this.type = type;
    }

    public BasicServiceImpl() {
    }

    public T createEntity(T object) {
        dao.save(object);
        return object;
    }

    public boolean delete(T object) {
        return dao.delete(object);
    }

    public T update(T object) {
        return dao.update(object);

    }

    public T getEntity(int id) {
        return dao.getById(id);
    }
}
