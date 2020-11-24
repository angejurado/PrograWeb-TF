package pe.edu.upc.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("from User u where u.nameUser like %:name%")
	List<User> findBynameUser(@Param("name")String nameUser);
	
	@Query("select count(d.nameUser) from User d where d.nameUser=:nameUser")
	public int searchUser(@Param("nameUser") String nameUser);
	
	@Query("from User u where u.typeUser='Dueño'")
	List<User> listOwners();
	
	@Query("from User u where u.typeUser='Cliente'")
	List<User> listCliente();
	
	@Query(value="select u.name_user, COUNT(u.name_user) from users u inner join reserves r on u.id_user=r.id_user\r\n" + 
			"inner join detailsreserves dr on r.id_reserve=dr.id_reserve\r\n" + 
			"group by u.name_user\r\n" + 
			"order by COUNT(u.name_user) desc\r\n" + 
			"limit 1",nativeQuery=true)
	public List<String[]>clienteMasFrecuente();
}