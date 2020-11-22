package pe.edu.upc.serviceinterface;

import pe.edu.upc.entity.DetailsReserve;

public interface IDetailsReserveService {
	
	public Integer insert(DetailsReserve dr);

	public void delete(Long idDetailReserve);

}
