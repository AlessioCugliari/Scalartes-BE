package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.dto.UtenteDTO;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
public class UtenteController {

    private UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id) throws NotFoundElementException {
        return utenteService.getUtenteById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente addUtente(@RequestBody UtenteDTO utenteDTO){
        return utenteService.addUtente(utenteDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Utente editUtente(@PathVariable Long id, @RequestBody UtenteDTO utenteDTO) throws NotFoundElementException {
        return utenteService.editUtente(id,utenteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUtenteById(@PathVariable Long id){
        utenteService.deleteUtenteById(id);
    }
}
