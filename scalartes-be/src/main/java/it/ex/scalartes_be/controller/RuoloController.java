package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.RuoloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ruolo")
public class RuoloController {

    private RuoloService ruoloService;

    @Autowired
    public RuoloController(RuoloService ruoloService) {
        this.ruoloService = ruoloService;
    }

    @GetMapping("/{id}")
    public Ruolo getRuoloById(@PathVariable Long id) throws NotFoundElementException {
        return ruoloService.getRuoloById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Ruolo addRuolo(@RequestBody RuoloDTO ruoloDTO){
        return ruoloService.addRuolo(ruoloDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ruolo editRuolo(@PathVariable Long id, @RequestBody RuoloDTO ruoloDTO) throws NotFoundElementException {
        return ruoloService.editRuolo(id,ruoloDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteRuoloById(@PathVariable Long id){
        ruoloService.deleteRuoloById(id);
    }
}
