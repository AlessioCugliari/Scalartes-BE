package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Torre;
import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.TorreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/torre")
public class TorreController {

    @Autowired
    private TorreService torreService;

    @Autowired
    public TorreController(TorreService torreService) {
        this.torreService = torreService;
    }

    @GetMapping("/{id}")
    public Torre getTorreById(@PathVariable Long id) throws NotFoundElementException {
        return torreService.getTorreById(id);
    }

    @GetMapping("/all")
    public List<Torre> getTorri() throws NotFoundElementException{
        return torreService.getAll();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Torre addTorre() {
        return torreService.addTorre();
    }

    @DeleteMapping("/{id}")
    public void deleteTorreById(@PathVariable Long id) {
        torreService.deleteTorreById(id);
    }
}
