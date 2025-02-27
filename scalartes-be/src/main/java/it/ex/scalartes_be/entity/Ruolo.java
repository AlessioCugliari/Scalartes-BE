package it.ex.scalartes_be.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name="RUOLO")
public class Ruolo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ruolo_seq_generator")
    @SequenceGenerator(name = "ruolo_seq_generator", sequenceName = "ruolo_seq", allocationSize = 1)
    private Long id;

    private String nomeRuolo;

    @OneToMany
    @JsonIgnore
    private List<Utente> listaUtente;
}
