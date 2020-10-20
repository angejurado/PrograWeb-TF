package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	public void insert (Brand bra);
	List<Brand>list();
}
