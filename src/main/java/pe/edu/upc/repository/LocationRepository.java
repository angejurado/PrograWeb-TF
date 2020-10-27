package pe.edu.upc.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{

}
