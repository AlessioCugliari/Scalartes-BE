package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Parete;
import it.ex.scalartes_be.service.PareteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parete")
public class PareteController {

    private PareteService pareteService;

    @Autowired
    public PareteController(PareteService pareteService) {
        this.pareteService = pareteService;
    }

    @GetMapping("/{id}")
    public Parete getPareteById(@PathVariable Long id) {
        return pareteService.getPareteById(id);
    }

    @DeleteMapping("/delete/")
    public void deletePareteById(@RequestParam("pareteid") Long id) {
        pareteService.deletePareteById(id);
    }
}
