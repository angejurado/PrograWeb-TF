package pe.edu.upc.serviceinterface;
import java.util.List;
import java.util.Optional;
import pe.edu.upc.entity.Brand;

public interface IBrandService {
	public int insert (Brand bra);
	List<Brand>list();
	
	List<Brand> findByBrand(String nameBrand);
	Optional<Brand> searchId(int idBrand);
}
