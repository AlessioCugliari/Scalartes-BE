package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.exceptions.NotFoundElementException;
import it.ex.scalartes_be.service.MuroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/muro")
@Slf4j
public class MuroController {

    private MuroService muroService;

    @Autowired
    public MuroController(MuroService muroService) {
        this.muroService = muroService;
    }

    @GetMapping("/{id}")
    public Muro getMuroById(@PathVariable Long id) throws NotFoundElementException {
        log.info("Request GET /muro/{}", id);
        return muroService.getMuroById(id);
    }

    @PostMapping("/add")
    public Muro addMuro(){
        log.info("Request POST muro/add/ {}");
        return muroService.addMuro();
    }

    @DeleteMapping("/delete/")
    public void deleteMuroById(@RequestParam("muroId") Long id){
        log.info("Request DELETE /muro/{}", id);
        muroService.deleteMuroById(id);
    }




}
