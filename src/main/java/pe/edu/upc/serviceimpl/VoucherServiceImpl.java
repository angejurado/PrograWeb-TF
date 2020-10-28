package pe.edu.upc.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upc.entity.Voucher;
import pe.edu.upc.repository.VoucherRepository;
import pe.edu.upc.serviceinterface.IVoucherService;

@Service
public class VoucherServiceImpl implements IVoucherService {
	@Autowired
	private VoucherRepository vR;

	@Override
	public void insert(Voucher vou) {
		try {
			vR.save(vou);
		} catch (Exception e) {
			System.out.println("Error en el serviceimpl Voucher");

		}
	}

	@Override
	public List<Voucher> list() {
		// TODO Auto-generated method stub
		return vR.findAll();
	}
}
