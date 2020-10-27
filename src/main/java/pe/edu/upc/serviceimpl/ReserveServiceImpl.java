package pe.edu.upc.serviceimpl;

import java.util.List;

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
	public void insert(Reserve res) {
		try {
			rR.save(res);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Reserve");
		}
	}

	@Override
	public List<Reserve> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}
