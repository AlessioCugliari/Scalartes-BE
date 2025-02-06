package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.service.MuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muro")
public class MuroController {

    private MuroService muroService;

    @Autowired
    public MuroController(MuroService muroService) {
        this.muroService = muroService;
    }

    @GetMapping("/{id}")
    public Muro getMuroById(@RequestParam Long id){
        return muroService.getMuroById(id);
    }

    @DeleteMapping("/delete/")
    public void deleteMuroById(@RequestParam("muroId") Long id){
        muroService.deleteMuroById(id);
    }




}
