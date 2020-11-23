package pe.edu.upc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.Reserve;

@Repository
public interface ReserveRepository extends JpaRepository<Reserve, Long>{
	
	@Query("select r from Reserve r join fetch r.reserveDetails dre join fetch dre.product where r.idReserve=?1")
	Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(Long id);
	
	@Query("from Reserve r where r.user.nameUser like %:busqueda% or r.store.nameBusiness like %:busqueda%")
	List<Reserve>searchByString(@Param("busqueda") String parametro);
	
	@Query("from Reserve r where r.getTotal()>=:busqueda")
	List<Reserve>searchByNumber(@Param("busqueda")Long parametro);
	
	@Query(value="select r.id_reserve,u.name_user,s.name_business,r.d_date,SUM(dr.quantity*p.m_price)\n" + 
			"from reserves r inner join stores s on r.id_store=s.id_store\n" + 
			"inner join users u on r.id_user=u.id_user\n" + 
			"inner join detailsreserves dr on r.id_reserve=dr.id_reserve\n" + 
			"inner join products p on dr.id_product=p.id_product\n" + 
			"where EXTRACT(MONTH FROM r.d_date)=?1\n" + 
			"group by r.id_reserve,u.name_user,s.name_business", nativeQuery=true)
	List<Reserve>vouchersDeUnMes(int mes);

}
