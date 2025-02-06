package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.service.ViaService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Via getViaById(@PathVariable Long id){
        return viaService.getViaById(id);
    }

    @DeleteMapping("/delete/")
    public void deleteViaById(@RequestParam("muroId") Long id ){
        viaService.deleteViaById(id);
    }
}
