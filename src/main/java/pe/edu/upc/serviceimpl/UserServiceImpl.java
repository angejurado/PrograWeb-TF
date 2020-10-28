package pe.edu.upc.serviceimpl;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.User;
import pe.edu.upc.repository.UserRepository;
import pe.edu.upc.serviceinterface.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private UserRepository uR;

	@Override
	public void insert(User use) {
		try {
			uR.save(use);
		} catch (Exception e) {
			System.out.println("Error al insertar en el serviceimpl user");
		}
		
	}

	@Override
	public List<User> list() {
		
		return uR.findAll();
	}

	@Override
	public List<User> findBynameUser(String nameUser) {
	
		return uR.findBynameUser(nameUser);
	}

}
