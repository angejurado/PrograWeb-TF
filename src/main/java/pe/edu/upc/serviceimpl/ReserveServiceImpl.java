package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.entity.Reserve;
import pe.edu.upc.repository.ReserveRepository;
import pe.edu.upc.serviceinterface.IReserveService;

@Service
public class ReserveServiceImpl implements IReserveService {
	
	@Autowired
	private ReserveRepository rR;
	
	
	@Override
	public boolean insert(Reserve reserve) {
		Reserve res = rR.save(reserve);
		if (res == null) {
			return false;
		} else {
			return true;
		}

	}

	
	@Override
	public List<Reserve> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}

	@Override
	public Reserve listarId(Long idReserve) {
		// TODO Auto-generated method stub
		Optional<Reserve> op = rR.findById(idReserve);
		return op.isPresent() ? op.get() : new Reserve();
	}

	@Override
	public Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(Long id) {
		// TODO Auto-generated method stub
		return rR.fetchByImportIdWhithImportDetailsWithProduct(id);
	}


	@Override
	public List<Reserve> findByString(String parametro) {
		// TODO Auto-generated method stub
		return rR.searchByString(parametro);
	}


	@Override
	public List<Reserve> findByNumber(Long parametro) {
		// TODO Auto-generated method stub
		return rR.searchByNumber(parametro);
	}
}
