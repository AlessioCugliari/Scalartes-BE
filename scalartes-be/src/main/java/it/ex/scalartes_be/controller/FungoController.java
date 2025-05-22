package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Fungo;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.FungoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fungo")
@Slf4j
public class FungoController {

    private FungoService fungoService;

    @Autowired
    public FungoController(FungoService fungoService) {
        this.fungoService = fungoService;
    }

    @GetMapping("/{id}")
    public Fungo getFungoById(@PathVariable Long id) throws NotFoundElementException {
        log.info("Request GET /fungo/{}", id);
        return fungoService.getFungoById(id);
    }

    @GetMapping("/muri")
    public List<Muro> getListMuri(){
        return fungoService.getListMuri();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Fungo addFungo(){
        log.info("Request POST fungo/add/ with body: ");
        return fungoService.addFungo();
    }

    @DeleteMapping("/{id}")
    public void deleteFungoById(@PathVariable Long id){
        log.info("Request DELETE /fungo/{}", id);
        fungoService.deleteFungoById(id);
    }

}
