package it.ex.scalartes_be.service;

import it.ex.scalartes_be.dto.ViaDTO;
import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.ViaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ViaService {

    private ViaRepository viaRepository;

    @Autowired
    public ViaService(ViaRepository viaRepository) {
        this.viaRepository = viaRepository;
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

        viaToAdd.setGrado(viaDTO.getGrado());
        viaToAdd.setParete(viaDTO.getParete());
        viaToAdd.setTracciatore(viaDTO.getTracciatore());
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

        viaFound.setGrado(viaDTO.getGrado());
        viaFound.setParete(viaDTO.getParete());
        viaFound.setTracciatore(viaDTO.getTracciatore());
        viaFound.setColore(viaDTO.getColore());
        viaFound.setDataTracciamento(viaDTO.getDataTracciamento());

        viaRepository.save(viaFound);

        return viaFound;

    }

    @Transactional
    public void deleteViaById(long id){
        viaRepository.deleteById(id);
    }
}
