package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.BloccoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blocco")
public class BloccoController {

    private BloccoService bloccoService;

    @Autowired
    public BloccoController(BloccoService bloccoService) {
        this.bloccoService = bloccoService;
    }

    @GetMapping("/{id}")
    public Blocco getBloccoById(@PathVariable Long id) throws NotFoundElementException {
        return bloccoService.getBloccoById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Blocco addBlocco(@RequestBody BloccoDTO bloccoDTO){
        return bloccoService.addBlocco(bloccoDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blocco editBlocco(@PathVariable Long id, @RequestBody BloccoDTO bloccoDTO) throws NotFoundElementException {
        return bloccoService.editBlocco(id,bloccoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBloccoById(@PathVariable Long id){
        bloccoService.deleteBloccoById(id);
    }
}
