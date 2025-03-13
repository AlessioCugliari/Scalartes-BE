package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Torre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TorreRepository extends JpaRepository<Torre,Long> {

}
