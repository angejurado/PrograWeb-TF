package pe.edu.upc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long>{
	
	@Query("select r from Reserve r join fetch r.reserveDetails dre join fetch dre.product where r.idReserve=?1")
	Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(Long id);

}
