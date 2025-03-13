package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Fungo;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.FungoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FungoService {

    private FungoRepository fungoRepository;

    @Autowired
    public FungoService(FungoRepository fungoRepository) {
        this.fungoRepository = fungoRepository;
    }

    public Fungo getFungoById(Long id) throws NotFoundElementException {

        Fungo fungoToFind = fungoRepository.findById(id).orElse(null);

        if(fungoToFind == null){
            throw new NotFoundElementException("Fungo con id: " + id + " non presente in DB");
        }

        return fungoToFind;
    }

    public Fungo addFungo() {

        Fungo fungoToAdd = new Fungo();

        fungoRepository.save(fungoToAdd);

        return fungoToAdd;
    }

    public void deleteFungoById(Long id) {
        fungoRepository.deleteById(id);
    }
}
