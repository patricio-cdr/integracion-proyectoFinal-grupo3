package pe.isil.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T, ID> {

    void create(T t);
    List<T> read();
    void update(T t);
    void delete(T t);
    Optional<T> readById(ID id);
}
