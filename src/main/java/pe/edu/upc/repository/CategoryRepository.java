package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Category;

@Repository

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	@Query("select count(c.nameCategory) from Category c where c.nameCategory=:nameCategory")
	public int searchCategory(@Param("nameCategory") String nameCategory);
	
	@Query(value="select c.name_category,COUNT(dr.quantity),SUM(dr.quantity) from detailsreserves dr inner join products p on dr.id_product=p.id_product\n" + 
			"inner join categories c on p.id_category=c.id_category \n" + 
			"group by c.name_category order by COUNT(dr.quantity) DESC limit 1",nativeQuery=true)
	public List<String[]> catMasSolicitada();
	
}
