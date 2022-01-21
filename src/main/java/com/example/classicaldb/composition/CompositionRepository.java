package com.example.classicaldb.composition;

import org.springframework.data.repository.CrudRepository;

public interface CompositionRepository extends CrudRepository<Composition, Integer> {
    public Long countById(Integer id);
}
