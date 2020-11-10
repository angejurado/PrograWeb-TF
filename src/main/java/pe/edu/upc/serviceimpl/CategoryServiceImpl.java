package pe.edu.upc.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.entity.Category;
import pe.edu.upc.repository.CategoryRepository;
import pe.edu.upc.serviceinterface.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {
	@Autowired
	private CategoryRepository cR;

	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public void delete(int idCategory) {
		// TODO Auto-generated method stub
		cR.deleteById(idCategory);
	}

	@Override
	public int insert(Category cate) {
		int rpta=cR.searchCategory(cate.getNameCategory());
		if(rpta==0)
		{
			cR.save(cate);
		}
		return rpta;
	}

	
}
