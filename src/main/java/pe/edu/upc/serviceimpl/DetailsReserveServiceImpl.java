package pe.edu.upc.serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.DetailsReserve;

import pe.edu.upc.repository.DetailsReserveRepository;
import pe.edu.upc.serviceinterface.IDetailsReserveService;

@Service
public class DetailsReserveServiceImpl implements IDetailsReserveService {

	
	@Autowired
	public DetailsReserveRepository drsR;
	

	@Override
	public Integer insert(DetailsReserve dr) {
		DetailsReserve drs = drsR.save(dr);
		if (drs == null) {
			return 0;
		} else {
			return 1;
		}
	}

	@Transactional
	@Override
	public void delete(Long idDetailReserve) {
	
		drsR.deleteById(idDetailReserve);
	}

}
