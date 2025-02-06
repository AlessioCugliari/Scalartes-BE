package it.ex.scalartes_be.dto;

import it.ex.scalartes_be.entity.Muro;
import it.ex.scalartes_be.entity.Utente;
import it.ex.scalartes_be.enums.Grado;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class BloccoDTO {

    private Muro muro;
    private String colore;
    private Grado grado;
    private Utente tracciatore;
    private List<String> note;
    //private Foto foto;
    private LocalDate dataTracciatura;
}
