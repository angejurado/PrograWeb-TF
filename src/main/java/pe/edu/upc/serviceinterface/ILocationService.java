package pe.edu.upc.serviceinterface;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Location;

public interface ILocationService {
	public void insert (Location loc);
	List<Location>list();
	Optional<Location> searchId(int idLocation);
}
