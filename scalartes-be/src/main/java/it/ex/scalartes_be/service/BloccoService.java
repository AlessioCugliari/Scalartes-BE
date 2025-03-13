package it.ex.scalartes_be.service;


import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.BloccoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BloccoService {

    private BloccoRepository bloccoRepository;

    @Autowired
    public BloccoService(BloccoRepository bloccoRepository) {
        this.bloccoRepository = bloccoRepository;
    }

    public Blocco getBloccoById(Long id) throws NotFoundElementException {

        Blocco bloccoToFind = bloccoRepository.findById(id).orElse(null);

        if(bloccoToFind == null){
            throw new NotFoundElementException("Blocco con id: " + id + " non presente in DB");
        }

        return bloccoToFind;
    }

    @Transactional
    public Blocco addBlocco(BloccoDTO bloccoDTO) {
        Blocco bloccoToAdd = new Blocco();

        bloccoToAdd.setGrado(bloccoDTO.getGrado());
        bloccoToAdd.setMuro(bloccoDTO.getMuro());
        bloccoToAdd.setTracciatore(bloccoDTO.getTracciatore());
        bloccoToAdd.setColore(bloccoDTO.getColore());
        bloccoToAdd.setDataTracciatura(bloccoDTO.getDataTracciatura());

        bloccoRepository.save(bloccoToAdd);

        return bloccoToAdd;
    }

    @Transactional
    public Blocco editBlocco(Long id, BloccoDTO bloccoDTO) throws NotFoundElementException {

        Blocco bloccoFound = bloccoRepository.findById(id).orElse(null);
        if(bloccoFound == null){
            throw new NotFoundElementException("Blocco con id: " + id + " non presente in DB");
        }

        bloccoFound.setGrado(bloccoDTO.getGrado());
        bloccoFound.setMuro(bloccoDTO.getMuro());
        bloccoFound.setTracciatore(bloccoDTO.getTracciatore());
        bloccoFound.setColore(bloccoDTO.getColore());
        bloccoFound.setDataTracciatura(bloccoDTO.getDataTracciatura());

        bloccoRepository.save(bloccoFound);

        return bloccoFound;

    }

    public void deleteBloccoById(Long id) {
        bloccoRepository.deleteById(id);
    }
}
