package pe.edu.upc.serviceimpl;

import java.util.List;  

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Store;
import pe.edu.upc.repository.StoreRepository;
import pe.edu.upc.serviceinterface.IStoreService;

@Service
public class StoreServiceImpl implements IStoreService {
	
	@Autowired
	private StoreRepository sR;
	
	@Transactional
	@Override
	public void insert(Store sto) {
		
			sR.save(sto);
		
		
	}

	@Override
	public List<Store> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}


    @Override
   	public List<Store> findByStore(String nameBusiness) {
   		// TODO Auto-generated method stub
   		return sR.findByStore(nameBusiness);
   	}
}