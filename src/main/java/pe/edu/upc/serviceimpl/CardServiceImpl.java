package pe.edu.upc.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Card;
import pe.edu.upc.entity.District;
import pe.edu.upc.repository.CardRepository;
import pe.edu.upc.serviceinterface.ICardService;

@Service
public class CardServiceImpl implements ICardService {
	
	@Autowired
	private CardRepository cR;
	
	@Override
	public void insert(Card car) {
		try {
			cR.save(car);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Card");
		}
	}

	@Override
	public List<Card> list() {
		// TODO Auto-generated method stub
		return cR.findAll();
	}

	@Override
	public List<Card> findCardsOfUser(int idUser) {
		// TODO Auto-generated method stub
		return cR.findCardsOfUser(idUser);
	}
	@Override
	public Optional<Card> searchId(int idCard) {
		// TODO Auto-generated method stub
		return cR.findById(idCard);
	}
}
