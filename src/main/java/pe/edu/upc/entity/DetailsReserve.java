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
	@JoinColumn(name="idReserve")
	private Reserve reserve;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@Column(name="mprice")
	private double mprice;
	
	@Column(name="quantity")
	private int quantity;

	public DetailsReserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DetailsReserve(int idDetailsReserve, Reserve reserve, Product product, double mprice, int quantity) {
		super();
		this.idDetailsReserve = idDetailsReserve;
		this.reserve = reserve;
		this.product = product;
		this.mprice = mprice;
		this.quantity = quantity;
	}

	public int getIdDetailsReserve() {
		return idDetailsReserve;
	}

	public void setIdDetailsReserve(int idDetailsReserve) {
		this.idDetailsReserve = idDetailsReserve;
	}

	public Reserve getReserve() {
		return reserve;
	}

	public void setReserve(Reserve reserve) {
		this.reserve = reserve;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getMprice() {
		return mprice;
	}

	public void setMprice(double mprice) {
		this.mprice = mprice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	

}
