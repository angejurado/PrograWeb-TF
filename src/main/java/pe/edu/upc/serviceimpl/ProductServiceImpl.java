package pe.edu.upc.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Product;
import pe.edu.upc.repository.ProductRepository;
import pe.edu.upc.serviceinterface.IProductService;

@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
    private ProductRepository pR;

	@Transactional
    @Override
    public void insert(Product pro) {
        try {
        	pR.save(pro);
        } catch (Exception e) {
            System.out.println("Error en el serviceimpl Product");
        }

    }

    @Override
    public List<Product> list() {
        // TODO Auto-generated method stub
        return pR.findAll();
    }
    
    @Override
   	public List<Product> findBynProduct(String nProduct) {
   		// TODO Auto-generated method stub
   		return pR.findBynProduct(nProduct);
   	}

	@Override
	public void delete(int idProduct) {
		pR.deleteById(idProduct);
		
	}

	@Override
	public Optional<Product> searchId(int idProduct) {
		// TODO Auto-generated method stub
		return pR.findById(idProduct);
	}
}