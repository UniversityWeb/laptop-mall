package com.webteam.laptopmall.infrastructure.repository;

import java.util.List;
import java.util.Optional;

public interface BaseRepos<T, ID> {
    T save(T entity);
    Optional<T> getById(ID id);
    T deleteById(ID id);
    List<T> getAll();
    int deleteAll();
}
