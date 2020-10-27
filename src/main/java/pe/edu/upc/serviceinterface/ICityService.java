package pe.edu.upc.serviceinterface;
import java.util.List;
import pe.edu.upc.entity.City;

public interface ICityService {
	public void insert (City cit);
	List<City>list();
}

