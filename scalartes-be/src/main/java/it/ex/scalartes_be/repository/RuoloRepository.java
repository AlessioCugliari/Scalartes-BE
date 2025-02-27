package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Long> {

    //Optional<Ruolo> findByNomeRuolo(String nomeRuolo);
    Ruolo findByNomeRuolo(String nomeRuolo);
}
