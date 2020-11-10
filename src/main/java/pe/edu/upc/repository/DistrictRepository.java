package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{

	@Query("select count(d.nameDistrict) from District d where d.nameDistrict=:nameDistrict")
	public int searchDistrict(@Param("nameDistrict") String nameDistrict);
}
