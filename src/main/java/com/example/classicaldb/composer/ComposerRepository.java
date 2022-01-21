package com.example.classicaldb.composer;

import org.springframework.data.repository.CrudRepository;

public interface ComposerRepository extends CrudRepository<Composer, Integer> {
    public Long countById(Integer id);
}
