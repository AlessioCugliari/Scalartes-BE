package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.RuoloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuoloService {

    private RuoloRepository ruoloRepository;

    @Autowired
    public RuoloService(RuoloRepository ruoloRepository) {
        this.ruoloRepository = ruoloRepository;
    }

    public Ruolo getRuoloById(Long id) throws NotFoundElementException {

        Ruolo ruoloFound = ruoloRepository.findById(id).orElse(null);

        if(ruoloFound == null){
            throw new NotFoundElementException("Ruolo con id: " + id + " non presente in DB");
        }

        return ruoloFound;
    }

    public Ruolo addRuolo(RuoloDTO ruoloDTO) {

        Ruolo ruoloToAdd = new Ruolo();

        ruoloToAdd.setNomeRuolo(ruoloDTO.getNomeRuolo());

        ruoloRepository.save(ruoloToAdd);

        return ruoloToAdd;
    }

    public Ruolo editRuolo(Long id, RuoloDTO ruoloDTO) throws NotFoundElementException {

        Ruolo ruoloFound = ruoloRepository.findById(id).orElse(null);
        if(ruoloFound == null){
            throw new NotFoundElementException("ruolo con id: " + id + " non presente in DB");
        }

        ruoloFound.setNomeRuolo(ruoloDTO.getNomeRuolo());

        ruoloRepository.save(ruoloFound);

        return ruoloFound;
    }

    public void deleteRuoloById(Long id) {
        ruoloRepository.deleteById(id);
    }
}
