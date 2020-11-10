package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import pe.edu.upc.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer>{
	
	@Query("from Card c where c.user.idUser like %:idUser%")
	List<Card> findCardsOfUser(@Param("idUser")int idUser);
	
	@Query("from Card c where c.numCard like %:name%")
	List<Card> findByCard(@Param("name")String numCard);
	
	@Query("select count(c.numCard) from Card c where c.numCard=:numCard")
	public int searchCard(@Param("numCard")String numCard);

}
