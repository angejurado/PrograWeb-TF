package pe.edu.upc.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

	@Query("from Store s where s.nameBusiness like %:name%")
	List<Store> findByStore(@Param("name")String nameBusiness);
}

