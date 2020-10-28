package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Voucher;

@Repository

public interface VoucherRepository extends JpaRepository<Voucher, Integer>{

}
