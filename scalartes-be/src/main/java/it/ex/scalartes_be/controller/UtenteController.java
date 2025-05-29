package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.RuoloDTO;
import it.ex.scalartes_be.dto.UtenteDTO;
import it.ex.scalartes_be.entity.Ruolo;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.UtenteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utente")
@Slf4j
public class UtenteController {

    private UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping("/{id}")
    public Utente getUtenteById(@PathVariable Long id) throws NotFoundElementException {
        log.info("Request GET /utente/{}", id);
        return utenteService.getUtenteById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente addUtente(@RequestBody UtenteDTO utenteDTO){
        log.info("Request POST utente/add/ with body: {}", utenteDTO);
        return utenteService.addUtente(utenteDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Utente editUtente(@PathVariable Long id, @RequestBody UtenteDTO utenteDTO) throws NotFoundElementException {
        log.info("Request put /utente/edit with id and doby: {} {}", id, utenteDTO);
        return utenteService.editUtente(id,utenteDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteUtenteById(@PathVariable Long id){
        log.info("Request DELETE /utente/{}", id);
        utenteService.deleteUtenteById(id);
    }
}
