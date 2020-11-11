package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pe.edu.upc.entity.Reserve;
import pe.edu.upc.repository.ReserveRepository;
import pe.edu.upc.serviceinterface.IReserveService;

@Service
public class ReserveServiceImpl implements IReserveService {
	
	@Autowired
	private ReserveRepository rR;
	
	@Transactional
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
	public Reserve listarId(int idReserve) {
		// TODO Auto-generated method stub
		Optional<Reserve> op = rR.findById(idReserve);
		return op.isPresent() ? op.get() : new Reserve();
	}

	@Override
	public Optional<Reserve> fetchByImportIdWhithImportDetailsWithProduct(int id) {
		// TODO Auto-generated method stub
		return rR.fetchByImportIdWhithImportDetailsWithProduct(id);
	}
}
