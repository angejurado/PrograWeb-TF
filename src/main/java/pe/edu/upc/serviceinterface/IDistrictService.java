package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.District;

public interface IDistrictService {
	public void insert (District dis);
	List<District>list();
	Optional<District> searchId(int idDistrict);
	public void delete(int idDistrict);
}
