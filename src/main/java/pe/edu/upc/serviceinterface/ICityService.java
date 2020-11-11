package pe.edu.upc.serviceinterface;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.City;


public interface ICityService {
	public int insert (City cit);
	List<City>list();
	Optional<City> searchId(int idCity);
	public void delete(int idCity);
}

