package it.ex.scalartes_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.ex.scalartes_be.entity.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente,Long> {
}
