package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloRepository extends JpaRepository<Ruolo,Long> {
}
