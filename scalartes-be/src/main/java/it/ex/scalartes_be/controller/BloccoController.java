package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.BloccoDTO;
import it.ex.scalartes_be.entity.Blocco;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.BloccoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/blocco")
@Slf4j
public class BloccoController {

    private BloccoService bloccoService;

    @Autowired
    public BloccoController(BloccoService bloccoService) {
        this.bloccoService = bloccoService;
    }

    @GetMapping("/{id}")
    public Blocco getBloccoById(@PathVariable Long id) throws NotFoundElementException {
        log.info("Request GET /blocco/{}", id);
        return bloccoService.getBloccoById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Blocco addBlocco(@RequestBody BloccoDTO bloccoDTO){
        log.info("Request POST blocco/add/ with body: {}", bloccoDTO);
        return bloccoService.addBlocco(bloccoDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Blocco editBlocco(@PathVariable Long id, @RequestBody BloccoDTO bloccoDTO) throws NotFoundElementException {
        log.info("Request put /blocco/edit with id and doby: {}", id, bloccoDTO);
        return bloccoService.editBlocco(id,bloccoDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBloccoById(@PathVariable Long id){
        log.info("Request DELETE /blocco/{}", id);
        bloccoService.deleteBloccoById(id);
    }
}
