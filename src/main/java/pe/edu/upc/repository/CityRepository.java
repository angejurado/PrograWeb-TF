package pe.edu.upc.repository;
import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.City ;
@Repository
public interface CityRepository extends JpaRepository<City, Integer>{
	@Query("select count(c.nameCity) from City c where c.nameCity=:nameCity")
	public int searchCity(@Param("nameCity") String nameCity);
}


