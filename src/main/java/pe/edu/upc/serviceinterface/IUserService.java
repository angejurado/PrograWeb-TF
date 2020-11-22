package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.User;

public interface IUserService {

public int insert(User use);

	List<User> list();

	List<User> findBynameUser(String nameUser);
	
	Optional<User> searchId(int idUser);
	
	public void delete(int idUser);
	
	List<User> listOwners();
	
	List<User> listClientes();

}
