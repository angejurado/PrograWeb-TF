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

	@Column(name = "numPrice", length = 35 ,nullable = false)
	private String numPrice;
	
	@Column(name = "dDate", length = 45, nullable = false)
	private String dDate;
		
	
	@Column(name="stateReserve", nullable=false)
	private int stateReserve;
		
	@ManyToOne
    @JoinColumn(name="idUser")
    private User user;
	
	@ManyToOne
    @JoinColumn(name="idCard")
    private Card card;
	
	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reserve(int idReserve, String numPrice, String dDate, int stateReserve, User user, Card card) {
		super();
		this.idReserve = idReserve;
		this.numPrice = numPrice;
		this.dDate = dDate;
		this.stateReserve = stateReserve;
		this.user = user;
		this.card = card;
	}

	public int getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(int idReserve) {
		this.idReserve = idReserve;
	}

	public String getNumPrice() {
		return numPrice;
	}

	public void setNumPrice(String numPrice) {
		this.numPrice = numPrice;
	}

	public String getdDate() {
		return dDate;
	}

	public void setdDate(String dDate) {
		this.dDate = dDate;
	}

	public int getstateReserve() {
		return stateReserve;
	}

	public void setstateReserve(int stateReserve) {
		this.stateReserve = stateReserve;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

		
}