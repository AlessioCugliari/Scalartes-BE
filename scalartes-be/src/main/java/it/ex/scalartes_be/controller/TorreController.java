package it.ex.scalartes_be.controller;

import it.ex.scalartes_be.entity.Via;
import it.ex.scalartes_be.service.TorreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/torre")
public class TorreController {

    @Autowired
    private TorreService torreService;
}
