package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.RuoloRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RuoloService {

    private RuoloRepository ruoloRepository;

    @Autowired
    public RuoloService(RuoloRepository ruoloRepository) {
        this.ruoloRepository = ruoloRepository;
    }

    public Ruolo getRuoloById(Long id) throws NotFoundElementException {

        log.info("Ricerca del ruolo con id={}", id);

        Ruolo ruoloFound = ruoloRepository.findById(id).orElse(null);

        if(ruoloFound == null){
            throw new NotFoundElementException("Ruolo con id: " + id + " non presente in DB");
        }

        log.debug("Ruolo trovato: {}", ruoloFound);

        return ruoloFound;
    }

    @Transactional
    public Ruolo addRuolo(RuoloDTO ruoloDTO) {

        log.info("Aggiunta di un nuovo ruolo: {}", ruoloDTO);

        Ruolo ruoloToAdd = new Ruolo();

        ruoloToAdd.setNomeRuolo(ruoloDTO.getNomeRuolo());

        ruoloRepository.save(ruoloToAdd);

        log.info("Ruolo aggiunto con successo: {}", ruoloToAdd);

        return ruoloToAdd;
    }

    @Transactional
    public Ruolo editRuolo(Long id, RuoloDTO ruoloDTO) throws NotFoundElementException {

        log.info("Edit del ruolo con id={}: nuovi dati {}", id, ruoloDTO);

        Ruolo ruoloFound = ruoloRepository.findById(id).orElse(null);
        if(ruoloFound == null){
            throw new NotFoundElementException("ruolo con id: " + id + " non presente in DB");
        }

        ruoloFound.setNomeRuolo(ruoloDTO.getNomeRuolo());

        ruoloRepository.save(ruoloFound);

        log.info("Ruolo modificato con successo: {}", ruoloFound);

        return ruoloFound;
    }

    public void deleteRuoloById(Long id) {

        log.info("Delete del ruolo con id={}", id);
        ruoloRepository.deleteById(id);
        log.info("Ruolo eliminato con id={}", id);
    }
}
