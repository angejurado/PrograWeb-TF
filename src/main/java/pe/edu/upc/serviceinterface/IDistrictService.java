package pe.edu.upc.serviceinterface;

import java.util.List;


import pe.edu.upc.entity.District;

public interface IDistrictService {
	public void insert (District dis);
	List<District>list();
}
