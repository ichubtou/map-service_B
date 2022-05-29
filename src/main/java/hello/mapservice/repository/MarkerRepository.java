package hello.mapservice.repository;

import java.util.List;

import hello.mapservice.model.Marker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public interface MarkerRepository extends JpaRepository<Marker, Integer> {
}
