package pe.edu.upc.serviceimpl;


import java.util.List;
import java.util.Optional;

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
	public int insert(Store sto) {
		int rpta=sR.searchStore(sto.getNameBusiness());
		if(rpta==0) {
			sR.save(sto);
		}
		return rpta;

	}

	@Override
	public List<Store> list() {
		// TODO Auto-generated method stub
		return sR.findAll();
	}


    

	@Override
	public void delete(int idStore) {
		// TODO Auto-generated method stub
		sR.deleteById(idStore);
		
	}

	@Override
   	public List<Store> findByStore(String nameBusiness) {	
   		// TODO Auto-generated method stub
   		return sR.findByStore(nameBusiness);
   	}
	@Override
	public Optional<Store> searchId(int idStore) {
		// TODO Auto-generated method stub
		return sR.findById(idStore);
	}
}