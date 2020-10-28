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
@Table(name="reserves")
public class Reserve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idReserve;

	@ManyToOne
    @JoinColumn(name="idProduct")
    private Product product;
		
	@Column(name = "numQuantity", nullable = false)
	private int numQuantity;
	
	@ManyToOne
    @JoinColumn(name="idCard")
    private Card card;	
		
	@Column(name = "numTotalPrice", nullable = false)
	private int numTotalPrice;
	
	@Column(name = "dDate", length = 45, nullable = false)
	private String dDate;

	
	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Reserve(int idReserve, Product product, int numQuantity, Card card, int numTotalPrice, String dDate) {
		super();
		this.idReserve = idReserve;
		this.product = product;
		this.numQuantity = numQuantity;
		this.card = card;
		this.numTotalPrice = numTotalPrice;
		this.dDate = dDate;
	}


	public int getIdReserve() {
		return idReserve;
	}


	public void setIdReserve(int idReserve) {
		this.idReserve = idReserve;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public int getNumQuantity() {
		return numQuantity;
	}


	public void setNumQuantity(int numQuantity) {
		this.numQuantity = numQuantity;
	}


	public Card getCard() {
		return card;
	}


	public void setCard(Card card) {
		this.card = card;
	}


	public int getNumTotalPrice() {
		return numTotalPrice;
	}


	public void setNumTotalPrice(int numTotalPrice) {
		this.numTotalPrice = numTotalPrice;
	}


	public String getdDate() {
		return dDate;
	}


	public void setdDate(String dDate) {
		this.dDate = dDate;
	}


		
}