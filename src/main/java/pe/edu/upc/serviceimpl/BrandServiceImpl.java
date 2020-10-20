package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.repository.BrandRepository;
import pe.edu.upc.serviceinterface.IBrandService;

@Service
public class BrandServiceImpl implements IBrandService {
	@Autowired
	private BrandRepository bR;
	
	@Override
	public void insert(Brand bra) {
		try {
			bR.save(bra);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Brand");
		}
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}
}
