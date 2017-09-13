package ap.dao;

import org.hibernate.HibernateException;

public interface BasicDao<T> {
    T getById(int id) throws HibernateException;

    T save(T object);

    T update(T object) throws HibernateException;

    boolean delete(T object) throws HibernateException;
}
