package it.ex.scalartes_be.entity;

import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "VIA")
public class Via {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "linea_id")
    private Parete parete;
    private String colore;
    private Grado grado;
    @ManyToOne
    private Utente tracciatore;
    private List<String> note;
    //private Foto foto; todo
    private LocalDate dataTracciamento;
}
