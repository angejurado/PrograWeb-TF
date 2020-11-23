package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Reserve;

public interface IReserveService {
	
	public boolean insert(Reserve res);
	
	public void delete(Long id);

	Reserve listarId(Long idReserve);

	List<Reserve>list();

	Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(Long id);
	
	List<Reserve>findByString(String parametro);
	
	List<Reserve>findByNumber(Long parametro);
	
	Optional<Reserve> searchId(Long idProduct);
}
