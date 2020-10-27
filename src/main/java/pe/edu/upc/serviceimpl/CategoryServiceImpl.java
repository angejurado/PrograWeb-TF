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
private CategoryRepository dR;

@Override
public void insert(Category cate) {
	try {
		dR.save(cate);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Category");

		}
	}

@Override
public List<Category> list() {
	// TODO Auto-generated method stub
	return null;
}
}


