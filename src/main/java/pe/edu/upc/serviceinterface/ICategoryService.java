package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Category;

public interface ICategoryService {
	public int insert(Category cate);

	List<Category> list();
	public void delete(int idCategory);
	
	public List<String[]> catMasPedida();
}
