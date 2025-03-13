package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.PareteDTO;
import it.ex.scalartes_be.entity.Parete;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.PareteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PareteService {

    private PareteRepository pareteRepository;

    @Autowired
    public PareteService(PareteRepository pareteRepository) {
        this.pareteRepository = pareteRepository;
    }

    public Parete getPareteById(long id) throws NotFoundElementException {
        Parete pareteToFind = pareteRepository.findById(id).orElse(null);

        if (pareteToFind ==null){
            throw new NotFoundElementException("Parete con id: " + id + " non presente in DB");
        }

        return pareteToFind;
    }

    public List<Parete> getAll() {
        return pareteRepository.findAll();
    }

    @Transactional
    public Parete addParete() {
        Parete pareteToAdd = new Parete();

        pareteRepository.save(pareteToAdd);

        return pareteToAdd;
    }

    @Transactional
    public void deletePareteById (long id) {
        pareteRepository.deleteById(id);
    }

}
