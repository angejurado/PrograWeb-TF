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
}