package it.ex.scalartes_be.repository;

import it.ex.scalartes_be.entity.Muro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuroRepository extends JpaRepository<Muro,Long> {
}
