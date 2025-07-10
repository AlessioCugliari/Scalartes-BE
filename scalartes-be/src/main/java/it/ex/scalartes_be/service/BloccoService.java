package it.ex.scalartes_be.service;


import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.enums.Grado;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.BloccoRepository;
import it.ex.scalartes_be.repository.MuroRepository;
import it.ex.scalartes_be.repository.UtenteRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BloccoService {

    private BloccoRepository bloccoRepository;
    private MuroRepository muroRepository;
    private UtenteRepository utenteRepository;

    @Autowired
    public BloccoService(BloccoRepository bloccoRepository, MuroRepository muroRepository, UtenteRepository utenteRepository) {
        this.bloccoRepository = bloccoRepository;
        this.muroRepository = muroRepository;
        this.utenteRepository = utenteRepository;
    }

    public Blocco getBloccoById(Long id) throws NotFoundElementException {

        log.info("Ricerca del blocco con id={}", id);
        Blocco bloccoToFind = bloccoRepository.findById(id).orElse(null);

        if(bloccoToFind == null){
            throw new NotFoundElementException("Blocco con id: " + id + " non presente in DB");
        }
        log.debug("Blocco trovato: {}", bloccoToFind);
        return bloccoToFind;
    }

    @Transactional
    public Blocco addBlocco(BloccoDTO bloccoDTO) {
        log.info("Aggiunta di un nuovo blocco: {}", bloccoDTO);
        Blocco bloccoToAdd = new Blocco();

        Grado grado = Grado.fromString(bloccoDTO.getGrado());
        bloccoToAdd.setGrado(grado);

        Muro muro = muroRepository.findById(bloccoDTO.getMuro()).orElse(null);
        bloccoToAdd.setMuro(muro);

        Utente tracciatore = utenteRepository.findByEmail(bloccoDTO.getTracciatore());
        bloccoToAdd.setTracciatore(tracciatore);

        bloccoToAdd.setNote(bloccoDTO.getNote());
        bloccoToAdd.setColore(bloccoDTO.getColore());
        bloccoToAdd.setDataTracciatura(bloccoDTO.getDataTracciatura());

        bloccoRepository.save(bloccoToAdd);
        log.info("Blocco aggiunto con successo: {}", bloccoToAdd);
        return bloccoToAdd;
    }

    @Transactional
    public Blocco editBlocco(Long id, BloccoDTO bloccoDTO) throws NotFoundElementException {

        log.info("Edit del blocco con id={}: nuovi dati {}", id, bloccoDTO);
        Blocco bloccoFound = bloccoRepository.findById(id).orElse(null);
        if(bloccoFound == null){
            throw new NotFoundElementException("Blocco con id: " + id + " non presente in DB");
        }

        Grado grado = Grado.fromString(bloccoDTO.getGrado());
        bloccoFound.setGrado(grado);

        Muro muro = muroRepository.findById(bloccoDTO.getMuro()).orElse(null);
        bloccoFound.setMuro(muro);

        Utente tracciatore = utenteRepository.findByEmail(bloccoDTO.getTracciatore());
        bloccoFound.setTracciatore(tracciatore);

        bloccoFound.setNote(bloccoDTO.getNote());
        bloccoFound.setColore(bloccoDTO.getColore());
        bloccoFound.setDataTracciatura(bloccoDTO.getDataTracciatura());

        bloccoRepository.save(bloccoFound);

        log.info("Blocco modificato con successo: {}", bloccoFound);
        return bloccoFound;

    }

    public void deleteBloccoById(Long id) {
        log.info("Delete del blocco con id={}", id);
        bloccoRepository.deleteById(id);
        log.info("Blocco eliminato con id={}", id);
    }
}
