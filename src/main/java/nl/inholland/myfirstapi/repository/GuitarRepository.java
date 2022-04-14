package nl.inholland.myfirstapi.repository;

import nl.inholland.myfirstapi.model.Guitar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Long> {

}
