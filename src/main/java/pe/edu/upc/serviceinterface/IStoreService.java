package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Store;

public interface IStoreService {
	public void insert(Store sto);
	public List<Store>list();
}
