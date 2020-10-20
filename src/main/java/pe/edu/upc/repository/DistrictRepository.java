package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.District;
@Repository
public interface DistrictRepository extends JpaRepository<District, Integer>{

}
