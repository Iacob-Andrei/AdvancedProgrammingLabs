package repository;

public interface AbstractRepo<T, ID, NAME> {

    void create(T entity);
    T findById(ID id);
    T findByName(NAME name);
}
