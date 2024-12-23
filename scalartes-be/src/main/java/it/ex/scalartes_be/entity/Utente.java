package it.ex.scalartes_be.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "UTENTE")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private String email;
    private String password;
    private String nome;
    private String cognome;

    @OneToMany
    private String Ruolo;

    //TODO LISTA CIRCUITI TRACCIATI E VIE TRACCIATE

}
