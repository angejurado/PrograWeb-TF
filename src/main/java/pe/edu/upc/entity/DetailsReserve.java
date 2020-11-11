package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detailsreserves")
public class DetailsReserve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetailsReserve;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@Column(name="quantity")
	private int quantity;

	public DetailsReserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailsReserve(int idDetailsReserve, Product product, int quantity) {
		super();
		this.idDetailsReserve = idDetailsReserve;
		this.product = product;
		this.quantity = quantity;
	}
	public Double calcularSubTotal() {
			return quantity * product.getMprice();
	}
	
	public int getIdDetailsReserve() {
		return idDetailsReserve;
	}

	public void setIdDetailsReserve(int idDetailsReserve) {
		this.idDetailsReserve = idDetailsReserve;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
	
	

}
