package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.ViaDTO;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.entity.Parete;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.enums.Grado;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.PareteRepository;
import it.ex.scalartes_be.repository.UtenteRepository;
import it.ex.scalartes_be.repository.ViaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ViaService {

    private ViaRepository viaRepository;
    private PareteRepository pareteRepository;
    private UtenteRepository utenteRepository;

    @Autowired
    public ViaService(ViaRepository viaRepository, PareteRepository pareteRepository, UtenteRepository utenteRepository) {
        this.viaRepository = viaRepository;
        this.pareteRepository = pareteRepository;
        this.utenteRepository = utenteRepository;
    }

    public Via getViaById(long id) throws NotFoundElementException {
        Via viaToFind = viaRepository.findById(id).orElse(null);

        if(viaToFind == null) {
            throw new NotFoundElementException("Via con id: " + id + " non presente in DB");
        }

        return viaToFind;
    }

    public List<Via> getAll(){
        return viaRepository.findAll();
    }

    @Transactional
    public Via addVia(ViaDTO viaDTO) {
        Via viaToAdd = new Via();

        Grado grado = Grado.fromString(viaDTO.getGrado());
        viaToAdd.setGrado(grado);

        Parete parete = pareteRepository.findById(viaDTO.getParete()).orElse(null);
        viaToAdd.setParete(parete);

        Utente tracciatore = utenteRepository.findByEmail(viaDTO.getTracciatore());
        viaToAdd.setTracciatore(tracciatore);

        viaToAdd.setColore(viaDTO.getColore());
        viaToAdd.setDataTracciamento(viaDTO.getDataTracciamento());

        viaRepository.save(viaToAdd);

        return viaToAdd;
    }

    @Transactional
    public Via editVia(Long id, ViaDTO viaDTO) throws NotFoundElementException {
        Via viaFound = viaRepository.findById(id).orElse(null);
        if(viaFound == null){
            throw new NotFoundElementException("Via con id: " + id + " non presente in DB");
        }

        Grado grado = Grado.fromString(viaDTO.getGrado());
        viaFound.setGrado(grado);

        Parete parete = pareteRepository.findById(viaDTO.getParete()).orElse(null);
        viaFound.setParete(parete);

        Utente tracciatore = utenteRepository.findByEmail(viaDTO.getTracciatore());
        viaFound.setTracciatore(tracciatore);

        viaFound.setColore(viaDTO.getColore());
        viaFound.setDataTracciamento(viaDTO.getDataTracciamento());

        viaRepository.save(viaFound);

        viaRepository.save(viaFound);

        return viaFound;

    }

    @Transactional
    public void deleteViaById(long id){
        viaRepository.deleteById(id);
    }
}
