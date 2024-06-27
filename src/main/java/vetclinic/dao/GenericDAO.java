package vetclinic.dao;

public interface GenericDAO<T> {
    void add(T entity);
    T get(int id);
    void update(T entity);
    void delete(int id);
}
