package it.ex.scalartes_be.entity;


import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "VIA")
public class Via {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String colore;
    private Grado grado;
    private Utente tracciatore;
    private List<String> note;
    //private foto foto; todo
    private LocalDate dataTracciamento;
}
