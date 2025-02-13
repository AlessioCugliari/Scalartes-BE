package it.ex.scalartes_be.service;


import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.repository.BloccoRepository;
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

    public Blocco addBlocco(BloccoDTO bloccoDTO) {
        Blocco bloccoToAdd = new Blocco();

        bloccoToAdd.setColore(bloccoDTO.getColore());

        return bloccoToAdd;
    }

    //TODO
    public Blocco editBlocco(BloccoDTO bloccoDTO) {
        return null;
    }

    public void deleteBloccoById(Long id) {
        bloccoRepository.deleteById(id);
    }
}
