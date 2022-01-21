package com.example.classicaldb.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CatalogueService {
    @Autowired
    private CatalogueRepository repo;

    public List<Catalogue> listAll() {
        return (List<Catalogue>) repo.findAll();
    }

    public void save(Catalogue catalogue) {
        repo.save(catalogue);
    }

    public Catalogue get(Integer id) throws CatalogueNotFoundException {
        Optional<Catalogue> result= repo.findById(id);
        if(result.isPresent()){
           return result.get();
        }
        throw new CatalogueNotFoundException("Could not find any catalogue with this id");
    }

    public void delete(Integer id) throws CatalogueNotFoundException{
        repo.deleteById(id);
    }
}
