package it.ex.scalartes_be.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "ruolo_id", nullable = false)
    private Ruolo ruolo;

    //TODO LISTA CIRCUITI TRACCIATI E VIE TRACCIATE

}
