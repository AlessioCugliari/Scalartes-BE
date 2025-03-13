package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Torre;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.TorreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TorreService {

    private TorreRepository torreRepository;

    @Autowired
    public TorreService(TorreRepository torreRepository) {
        this.torreRepository = torreRepository;
    }

    public Torre getTorreById(long id) throws NotFoundElementException {
        Torre torreToFound = torreRepository.findById(id).orElse(null);

        if(torreToFound == null) {
            throw new NotFoundElementException("Torre con id: " + id + " non presente in DB");
        }

        return torreToFound;
    }

    public List<Torre> getAll() {
        return torreRepository.findAll();
    }

    public Torre addTorre() {
        Torre torreToAdd = new Torre();

        torreRepository.save(torreToAdd);

        return torreToAdd;
    }

    public void deleteTorreById(long id) {
        torreRepository.deleteById(id);
    }
}
