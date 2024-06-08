package com.mohammad_bakur.Dealer_management_api;

import java.util.List;
import java.util.Optional;

public interface DataAccessObject<T>{
    void insert(T entity);
    void removeById(Integer id);
    void update(T entity);
    Optional<T> getById(Integer id);
    List<T> getAll();
    boolean existsWithId(Integer id);
    boolean existsWithEmail(String email);
}
