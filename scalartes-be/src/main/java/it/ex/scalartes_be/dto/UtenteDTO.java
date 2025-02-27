package it.ex.scalartes_be.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UtenteDTO {

    private String userName;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String ruolo;
}
