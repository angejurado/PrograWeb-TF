package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.District;
import pe.edu.upc.repository.DistrictRepository;
import pe.edu.upc.serviceinterface.IDistrictService;

@Service
public class DistrictServiceImpl implements IDistrictService {
	@Autowired
	private DistrictRepository dR;
	
	@Override
	public void insert(District dis) {
		try {
			dR.save(dis);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl District");
		}
	}

	@Override
	public List<District> list() {
		// TODO Auto-generated method stub
		return dR.findAll();
	}
	
	@Override
	public Optional<District> searchId(int idDistrict) {
		// TODO Auto-generated method stub
		return dR.findById(idDistrict);
	}
	
	@Override
	public void delete(int idDistrict) {
		dR.deleteById(idDistrict);
	}

	
}
