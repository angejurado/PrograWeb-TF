package pe.edu.upc.serviceimpl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.entity.Location;
import pe.edu.upc.repository.LocationRepository;
import pe.edu.upc.serviceinterface.ILocationService;

@Service
public class LocationServiceImpl implements ILocationService {
	@Autowired
	private LocationRepository lR;
	
	

	@Override
	public List<Location> list() {
		// TODO Auto-generated method stub
		return lR.findAll();
	}

	
	
	@Override
	public int insert(Location loc) {
		int rpta=lR.searchLocation(loc.getNameDirection());
		if(rpta ==0)
		{
			lR.save(loc);
		}
		return rpta;
		
	}
	
	@Override
	public List<Location> findByLocation(String nameDirection) {
		// TODO Auto-generated method stub
		return lR.findByLocation(nameDirection);
	}
	
	@Override
	public Optional<Location> searchId(int idLocation) {
		// TODO Auto-generated method stub
		return lR.findById(idLocation);
	}



	@Override
	public void delete(int idLocation) {
		// TODO Auto-generated method stub
		lR.deleteById(idLocation);
	}

	
}

