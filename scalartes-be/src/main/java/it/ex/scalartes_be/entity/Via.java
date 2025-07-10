package it.ex.scalartes_be.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"parete", "tracciatore"})
@Table(name = "VIA")
public class Via {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "patere_id")

    private Parete parete;

    private String colore;

    private Grado grado;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonIgnore
    private Utente tracciatore;

    private List<String> note;

    //private Foto foto; todo

    private LocalDate dataTracciamento;
}
