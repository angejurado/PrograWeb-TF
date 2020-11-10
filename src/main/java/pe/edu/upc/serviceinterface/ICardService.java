package pe.edu.upc.serviceinterface;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import pe.edu.upc.entity.Card;

public interface ICardService {
	
	public void insert(@Valid Card card);

	List<Card> list();
	
	List<Card> findCardsOfUser(int idUser);

	Optional<Card> searchId(int idCard);
}
