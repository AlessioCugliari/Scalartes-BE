package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Blocco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BloccoRepository extends JpaRepository<Blocco, Long> {
}
