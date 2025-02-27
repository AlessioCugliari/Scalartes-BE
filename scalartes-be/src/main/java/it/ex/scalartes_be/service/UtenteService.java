package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.dto.UtenteDTO;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.RuoloRepository;
import it.ex.scalartes_be.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;
    private final RuoloRepository ruoloRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository, RuoloRepository ruoloRepository) {
        this.utenteRepository = utenteRepository;
        this.ruoloRepository = ruoloRepository;
    }

    public Utente getUtenteById(Long id) throws NotFoundElementException {
        Utente utenteFound = utenteRepository.findById(id).orElse(null);

        if(utenteFound == null){
            throw new NotFoundElementException("Utente con id: " + id + " non presente in DB");
        }
        return utenteFound;
    }

    @Transactional
    public Utente addUtente(UtenteDTO utenteDTO) {

        Utente utenteToAdd = new Utente();

        utenteToAdd.setCognome(utenteDTO.getCognome());
        utenteToAdd.setNome(utenteDTO.getNome());
        utenteToAdd.setEmail(utenteDTO.getEmail());
        utenteToAdd.setPassword(utenteDTO.getPassword());
        utenteToAdd.setUserName(utenteDTO.getUserName());

        Ruolo ruolo = ruoloRepository.findByNomeRuolo(utenteDTO.getRuolo());
        System.out.println("RUOLO " + ruolo.getNomeRuolo());
        utenteToAdd.setRuolo(ruolo);

        utenteRepository.save(utenteToAdd);

        return utenteToAdd;
    }

    public Utente editUtente(Long id, UtenteDTO utenteDTO) throws NotFoundElementException {

        Utente utenteFound = utenteRepository.findById(id).orElse(null);

        if(utenteFound == null){
            throw new NotFoundElementException("Utente con id: " + id + " non presente in DB");
        }

        utenteFound.setCognome(utenteDTO.getCognome());
        utenteFound.setNome(utenteDTO.getNome());
        utenteFound.setEmail(utenteDTO.getEmail());
        utenteFound.setPassword(utenteDTO.getPassword());
        utenteFound.setUserName(utenteDTO.getUserName());

        utenteRepository.save(utenteFound);

        return utenteFound;
    }

    public void deleteUtenteById(Long id) {
        utenteRepository.deleteById(id);
    }
}
