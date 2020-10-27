package pe.edu.upc.serviceimpl;
import java.util.List;
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
	public void insert(Location loc) {
		try {
			lR.save(loc);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Location");
		}
	}

	@Override
	public List<Location> list() {
		// TODO Auto-generated method stub
		return lR.findAll();
	}
}

