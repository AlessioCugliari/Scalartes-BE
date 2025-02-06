package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.repository.ViaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViaService {

    private ViaRepository viaRepository;

    @Autowired
    public ViaService(ViaRepository viaRepository) {
        this.viaRepository = viaRepository;
    }

    public Via getViaById(long id){
        return viaRepository.getById(id);
    }

    public List<Via> getAll(){
        return viaRepository.findAll();
    }

    public void deleteViaById(long id){
        viaRepository.deleteById(id);
    }

    public Via saveVia(Via via){
        return viaRepository.save(via);
    }
}
