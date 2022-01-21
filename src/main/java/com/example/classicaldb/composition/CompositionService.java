package com.example.classicaldb.composition;

import com.example.classicaldb.composition.Composition;
import com.example.classicaldb.composition.CompositionNotFoundException;
import com.example.classicaldb.composition.CompositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompositionService {
    @Autowired private CompositionRepository repo;

    public List<Composition> listAll() {
        return (List<Composition>) repo.findAll();
    }

    public void save(Composition composition) {
        repo.save(composition);
    }

    public Composition get(Integer id) throws CompositionNotFoundException {
        Optional<Composition> result= repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new CompositionNotFoundException("Could not find any composition with this id");
    }

    public void delete(Integer id) throws CompositionNotFoundException{
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new CompositionNotFoundException("Could not find any composition with this id");
        }
        repo.deleteById(id);
    }
}
