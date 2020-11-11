package pe.edu.upc.serviceinterface;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Location;

public interface ILocationService {
	public int insert (Location loc);
	List<Location>list();
	
	
	Optional<Location> searchId(int idLocation);
	List<Location> findByLocation(String nameDirection);
	public void delete(int idLocation);
}
