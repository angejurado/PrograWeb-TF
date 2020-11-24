package pe.edu.upc.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Product;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Integer>{

	@Query("from Product p where p.nProduct like %:name%")
	List<Product> findBynProduct(@Param("name")String nProduct);
		
	@Query("from Product p where p.mprice =:price")
	List<Product> findByPrice(@Param("price") Double mPrice);
	
	@Query("select count(p.nProduct) from Product p where p.nProduct=:nProduct")
	public int searchProduct(@Param("nProduct") String nProduct);
	
	@Query(value="select p.n_product, SUM(dr.quantity)\n" + 
			"from detailsreserves dr inner join products p on dr.id_product=p.id_product\n" + 
			"group by p.n_product\n" + 
			"order by SUM(dr.quantity)\n" + 
			"desc limit 10",nativeQuery=true)
	public List<String[]> top10Productos();
}
