package dao;

import java.util.List;

/**
 * Created by employee on 11/2/15.
 */
public interface BaseDAOInterface<T> {
    List<T> getTableRows();

    T getById(int id);

    void save(T object);

    void delete(T object);

    void update(T object);
}
