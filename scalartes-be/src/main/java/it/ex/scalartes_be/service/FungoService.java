package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Fungo;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.FungoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FungoService {

    private FungoRepository fungoRepository;

    @Autowired
    public FungoService(FungoRepository fungoRepository) {
        this.fungoRepository = fungoRepository;
    }

    public Fungo getFungoById(Long id) throws NotFoundElementException {

        log.info("Ricerca del fungo con id={}", id);

        Fungo fungoToFind = fungoRepository.findById(id).orElse(null);

        if(fungoToFind == null){
            throw new NotFoundElementException("Fungo con id: " + id + " non presente in DB");
        }

        log.debug("fungo trovato: {}", fungoToFind);
        
        return fungoToFind;
    }

    public List<Muro> getListMuri() {

        log.info("Ricerca di tutti i muri presenti sul fungo");

        return fungoRepository.findAll()
                .stream()
                .flatMap(fungo -> fungo.getListaMuri().stream())
                .collect(Collectors.toList());
    }

    public Fungo addFungo() {

        log.info("Aggiunta di un nuovo fungo:");

        Fungo fungoToAdd = new Fungo();

        fungoRepository.save(fungoToAdd);

        log.info("fungo aggiunto con successo");

        return fungoToAdd;
    }

    public void deleteFungoById(Long id) {

        log.info("Delete del fungo con id={}", id);
        fungoRepository.deleteById(id);
        log.info("fungo eliminato con id={}", id);
    }


}
