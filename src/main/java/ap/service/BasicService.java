package ap.service;

public interface BasicService<T> {
    T createEntity(T object);

    boolean delete(T object);

    T update(T object);

    T getEntity(int id);
}
