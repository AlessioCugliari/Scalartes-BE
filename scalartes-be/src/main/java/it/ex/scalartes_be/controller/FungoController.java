package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.service.FungoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fungo")
public class FungoController {

    @Autowired
    private FungoService fungoService;


}
