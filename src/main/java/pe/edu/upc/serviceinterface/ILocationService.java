package pe.edu.upc.serviceinterface;
import java.util.List;
import pe.edu.upc.entity.Location;

public interface ILocationService {
	public void insert (Location loc);
	List<Location>list();
}
