package ap.dao;

public interface BasicDao<T> {
    T getById(int id);

    T save(T object);

    T update(T object);

    boolean delete(T object);
}
