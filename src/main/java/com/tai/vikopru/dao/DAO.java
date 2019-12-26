package com.tai.vikopru.dao;

import java.util.List;
import java.util.Optional;

public interface DAO<T> {
    Optional<T> get(Long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(Long id);
}