package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Store;

public interface IStoreService {

	public int insert(Store sto);
	public List<Store>list();
	List<Store> findByStore(String nameBusiness);
	public void delete(int idStore);
	Optional<Store> searchId(int idStore);
	
}
