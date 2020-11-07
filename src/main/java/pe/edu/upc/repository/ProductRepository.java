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
	
	
	@Query("select count(p.nProduct) from Product p where p.nProduct=:nProduct")
	public int searchProduct(@Param("nProduct") String nProduct);
}
