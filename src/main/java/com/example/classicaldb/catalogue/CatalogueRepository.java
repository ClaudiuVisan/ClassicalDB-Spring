package com.example.classicaldb.catalogue;

import org.springframework.data.repository.CrudRepository;

public interface CatalogueRepository extends CrudRepository<Catalogue, Integer>{
   // public Long countById(Integer id);
}
