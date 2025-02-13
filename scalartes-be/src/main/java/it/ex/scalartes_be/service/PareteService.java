package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Parete;
import it.ex.scalartes_be.repository.PareteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PareteService {

    private PareteRepository pareteRepository;

    @Autowired
    public PareteService(PareteRepository pareteRepository) {
        this.pareteRepository = pareteRepository;
    }

    public Parete getPareteById(long id) {
        return pareteRepository.getById(id);
    }

    public List<Parete> getAll() {
        return pareteRepository.findAll();
    }

    public void deletePareteById (long id) {
        pareteRepository.deleteById(id);
    }

    public Parete saveParete (Parete parete) {
        return pareteRepository.save(parete);
    }
}
