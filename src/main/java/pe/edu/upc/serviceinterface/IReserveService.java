package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Reserve;

public interface IReserveService {
	
	public boolean insert(Reserve res);

	Reserve listarId(int idReserve);

	List<Reserve>list();

	Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(int id);
}
