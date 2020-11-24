package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Product;

public interface IProductService {

	public void insert(Product pro);

	List<Product> list();

	List<Product> findBynProduct(String nProduct);

	public void delete(int idProduct);

	Optional<Product> searchId(int idProduct);
	
	List<Product> findByPrice(Double mPrice);
	
	public List<String[]> top10Productos();
	
	public List<String[]> productoMenosVendido();
}