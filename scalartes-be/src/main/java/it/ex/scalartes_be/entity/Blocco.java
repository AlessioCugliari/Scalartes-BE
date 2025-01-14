package it.ex.scalartes_be.entity;

import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "BLOCCO")
public class Blocco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "muro_id")
    private Muro muro;
    private String colore;
    private Grado grado;
    @ManyToOne
    private Utente tracciatore;
    private List<String> note;
    //private Foto foto;
    private LocalDate dataTracciatura;
}
