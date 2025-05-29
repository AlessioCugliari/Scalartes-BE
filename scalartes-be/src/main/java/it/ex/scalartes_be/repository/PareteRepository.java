package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Parete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PareteRepository extends JpaRepository<Parete,Long> {

}
