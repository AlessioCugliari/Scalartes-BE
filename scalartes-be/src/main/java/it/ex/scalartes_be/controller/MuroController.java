package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.service.MuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/muro")
public class MuroController {

    @Autowired
    private MuroService muroService;

    /*@GetMapping("/{id}")
    public Muro getMuroById(@RequestParam Long id){
        return muroService.getMuroById(id);
    }*/




}
