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

}
