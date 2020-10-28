package pe.edu.upc.serviceinterface;

import java.util.List;

import pe.edu.upc.entity.Voucher;

public interface IVoucherService {
public void insert(Voucher vou);

List<Voucher>list();
}
