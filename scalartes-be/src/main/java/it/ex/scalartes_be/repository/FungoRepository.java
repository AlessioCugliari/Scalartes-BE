package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Fungo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FungoRepository extends JpaRepository<Fungo,Long> {

}
