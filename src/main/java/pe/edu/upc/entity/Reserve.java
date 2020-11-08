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
	@JoinColumn(name="idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idStore")
	private Store store;
	
	@ManyToOne
    @JoinColumn(name="idCard")
    private Card card;	
		
	@Column(name = "numTotalPrice", nullable = false)
	private double numTotalPrice;
	
	@Column(name = "dDate", length = 45, nullable = false)
	private String dDate;
	

	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Reserve(int idReserve, User user, Store store, Card card, double numTotalPrice, String dDate) {
		super();
		this.idReserve = idReserve;
		this.user = user;
		this.store = store;
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



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



	public Store getStore() {
		return store;
	}



	public void setStore(Store store) {
		this.store = store;
	}



	public Card getCard() {
		return card;
	}



	public void setCard(Card card) {
		this.card = card;
	}



	public double getNumTotalPrice() {
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