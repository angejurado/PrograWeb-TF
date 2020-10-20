package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Brand;
@Repository
public interface BrandRepository extends JpaRepository<Brand, Integer>{

}
