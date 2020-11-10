package pe.edu.upc.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.entity.City;
import pe.edu.upc.repository.CityRepository;
import pe.edu.upc.serviceinterface.ICityService;

@Service
public class CityServiceImpl implements ICityService {
	@Autowired
	private CityRepository cR;
	
	

	@Override
	public List<City> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
		
	}

	@Override
	public Optional<City> searchId(int idCity) {
		// TODO Auto-generated method stub
		return cR.findById(idCity);
	}
	@Override
	public int insert(City cit) {
		int rpta=cR.searchCity(cit.getNameCity());
		if(rpta==0)
		{
			cR.save(cit);
		}
		return rpta;

	}
}
