package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsReserveRepository {

	
	@Query("select sum(dr..mprice*dr.quantity) from DetailsReserve dr")
	public double calculateTotal();
}
