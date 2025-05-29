package it.ex.scalartes_be.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@ToString(exclude = {"muro", "tracciatore"})
@Table(name = "BLOCCO")
public class Blocco {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "muro_id")
    private Muro muro;

    private String colore;

    //@Enumerated(EnumType.STRING)
    private Grado grado;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "utente_id", nullable = false)
    @JsonIgnore
    private Utente tracciatore;

    private List<String> note;
    //private Foto foto;

    private LocalDate dataTracciatura;
}
