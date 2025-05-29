package it.ex.scalartes_be.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    @OneToMany
    @JoinColumn(name = "via_id")
    private List<Via> listVie;

    @OneToMany
    @JoinColumn(name = "blocco_id")
    private List<Blocco> listBlocchi;

    @OneToMany(mappedBy = "tracciatore", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Blocco> listaBlocchiTracciati;

}
