package com.example.classicaldb.composer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComposerService {
    @Autowired private ComposerRepository repo;

    public List<Composer> listAll() {
        return (List<Composer>) repo.findAll();
    }

    public void save(Composer composer) {
        repo.save(composer);
    }

    public Composer get(Integer id) throws ComposerNotFoundException{
        Optional<Composer> result= repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new ComposerNotFoundException("Could not find any composer with this id");
    }

    public void delete(Integer id) throws ComposerNotFoundException{
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new ComposerNotFoundException("Could not find any composer with this id");
        }
        repo.deleteById(id);
    }
}
