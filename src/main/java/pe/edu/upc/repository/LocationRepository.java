package pe.edu.upc.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entity.Location;
@Repository
public interface LocationRepository extends JpaRepository<Location, Integer>{
	@Query("from Location l where l.nameDirection like %:name%")
	List<Location> findByLocation(@Param("name")String nameDirection);
	
	
	
	@Query("select count(l.nameDirection) from Location l where l.nameDirection=:nameDirection")
	public int searchLocation(@Param("nameDirection")String nameBrand);
}
