package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Store;
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

}

