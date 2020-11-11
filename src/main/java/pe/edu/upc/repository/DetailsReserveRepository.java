package pe.edu.upc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.DetailsReserve;

@Repository
public interface DetailsReserveRepository extends JpaRepository<DetailsReserve, Integer> {

	
	
}
