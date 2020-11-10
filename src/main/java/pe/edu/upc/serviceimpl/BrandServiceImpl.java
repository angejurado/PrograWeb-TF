package pe.edu.upc.serviceimpl;
import java.util.List;
import java.util.Optional;
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
	public int insert(Brand bra) {
		int rpta= bR.searchBrand(bra.getNameBrand());
		if(rpta==0)
		{
			bR.save(bra);
		}
		
		return rpta;
		
	}

	@Override
	public List<Brand> list() {
		// TODO Auto-generated method stub
		return bR.findAll();
	}

	@Override
	public List<Brand> findByBrand(String nameBrand) {
		// TODO Auto-generated method stub
		return bR.findByBrand(nameBrand);
	}

	@Override
	public Optional<Brand> searchId(int idBrand) {
		// TODO Auto-generated method stub
		return bR.findById(idBrand);
	}
	
	
	
}
