package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Fungo;
import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.FungoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fungo")
public class FungoController {

    private FungoService fungoService;

    @Autowired
    public FungoController(FungoService fungoService) {
        this.fungoService = fungoService;
    }

    @GetMapping("/{id}")
    public Fungo getFungoById(@PathVariable Long id) throws NotFoundElementException {
        return fungoService.getFungoById(id);
    }

    @GetMapping("/muri")
    public List<Muro> getListMuri(){
        return fungoService.getListMuri();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Fungo addFungo(){
        return fungoService.addFungo();
    }

    @DeleteMapping("/{id}")
    public void deleteFungoById(@PathVariable Long id){
        fungoService.deleteFungoById(id);
    }

}
