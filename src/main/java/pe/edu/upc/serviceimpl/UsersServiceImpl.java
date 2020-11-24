package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Users;
import pe.edu.upc.repository.UsersRepository;
import pe.edu.upc.serviceinterface.IUsersService;

@Service
public class UsersServiceImpl implements IUsersService {
	@Autowired
	private UsersRepository uR;

	@Override
	public void insert(Users users) {
		uR.save(users);
	}

	@Override
	public List<Users> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}
}
