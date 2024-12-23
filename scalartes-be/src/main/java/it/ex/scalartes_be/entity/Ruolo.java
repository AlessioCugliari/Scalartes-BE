package it.ex.scalartes_be.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomeRuolo;

    @OneToMany
    private List<Utente> listaUtente;
}
