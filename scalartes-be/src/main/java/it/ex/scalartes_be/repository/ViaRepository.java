package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Via;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaRepository extends JpaRepository<Via,Long> {

}
