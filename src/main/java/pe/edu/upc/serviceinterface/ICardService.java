package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.entity.Card;

public interface ICardService {
	
	public int insert(@Valid Card card);

	List<Card> list();
	
	List<Card> findCardsOfUser(int idUser);

	Optional<Card> searchId(int idCard);

	public List<Card> findByCard(String numCard);
	
}
