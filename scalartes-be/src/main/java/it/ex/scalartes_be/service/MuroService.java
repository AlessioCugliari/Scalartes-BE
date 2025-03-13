package it.ex.scalartes_be.service;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.repository.MuroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MuroService {

    private MuroRepository muroRepository;

    @Autowired
    public MuroService(MuroRepository muroRepository) {
        this.muroRepository = muroRepository;
    }


    public Muro getMuroById(Long id) {
        return muroRepository.getById(id);
    }

    public Muro addMuro() {

        Muro muroToAdd = new Muro();

        muroRepository.save(muroToAdd);

        return muroToAdd;
    }

    public void deleteMuroById(Long id) {
        muroRepository.deleteById(id);
    }


}
