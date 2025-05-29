package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.MuroRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MuroService {

    private MuroRepository muroRepository;

    @Autowired
    public MuroService(MuroRepository muroRepository) {
        this.muroRepository = muroRepository;
    }


    public Muro getMuroById(Long id) throws NotFoundElementException{

        log.info("Ricerca del muro con id={}", id);

        Muro muroToFind = muroRepository.getById(id);

        if(muroToFind == null){
            throw new NotFoundElementException("Muro con id: " + id + " non presente in DB");
        }

        log.debug("Muro trovato: {}", muroToFind);

        return muroToFind;
    }

    public Muro addMuro() {

        log.info("Aggiunta di un nuovo muro: {}");

        Muro muroToAdd = new Muro();
        muroRepository.save(muroToAdd);

        log.info("Muro aggiunto con successo: {}");
        return muroToAdd;
    }

    public void deleteMuroById(Long id) {
        log.info("Delete muro con id={}", id);
        muroRepository.deleteById(id);
        log.info("Muro eliminato con id={}", id);
    }


}
