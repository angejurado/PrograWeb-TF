package pe.edu.upc.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.entity.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{
	@Query("from Brand b where b.nameBrand like %:name%")
	List<Brand> findByBrand(@Param("name")String nameBrand);
	
	@Query("select count(b.nameBrand) from Brand b where b.nameBrand=:nameBrand")
	public int searchBrand(@Param("nameBrand")String nameBrand);
}
