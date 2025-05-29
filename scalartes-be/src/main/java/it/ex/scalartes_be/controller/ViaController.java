package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.dto.ViaDTO;
import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/via")
public class ViaController {

    private ViaService viaService;

    @Autowired
    public ViaController(ViaService viaService) {
        this.viaService = viaService;
    }

    @GetMapping("/{id}")
    public Via getViaById(@PathVariable Long id) throws NotFoundElementException {
        return viaService.getViaById(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Via addVia(@RequestBody ViaDTO viaDTO) {
        return viaService.addVia(viaDTO);
    }

    @PutMapping("/edit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Via editVia(@PathVariable Long id, @RequestBody ViaDTO viaDTO) throws NotFoundElementException {
        return viaService.editVia(id, viaDTO);
    }

    @DeleteMapping("/delete/")
    public void deleteViaById(@RequestParam("muroId") Long id ){
        viaService.deleteViaById(id);
    }
}
