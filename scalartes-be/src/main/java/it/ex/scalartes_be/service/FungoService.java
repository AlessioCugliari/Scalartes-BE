package it.ex.scalartes_be.service;

import it.ex.scalartes_be.repository.FungoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FungoService {

    @Autowired
    private FungoRepository fungoRepository;
}
