package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
@Entity
@Table(name="cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCard;
	
	
	@Column(name = "numCard", length = 16 ,nullable = false)
	private String numCard;
	
	@Column(name = "dExpiration", length = 45, nullable = false)
	private String dExpiration;

	@Min(value=100, message="El código debe de 3 cifras")
    @Max(value=999, message="El código debe de 3 cifras")
	@Column(name = "codeCard", length = 55, nullable = false)
	private int codeCard;
	
	@ManyToOne
    @JoinColumn(name="idUser")
    private User user;

	public Card(int idCard, String numCard, String dExpiration,
			@Min(value = 100, message = "El código debe de 3 cifras") @Max(value = 999, message = "El código debe de 3 cifras") int codeCard,
			User user) {
		super();
		this.idCard = idCard;
		this.numCard = numCard;
		this.dExpiration = dExpiration;
		this.codeCard = codeCard;
		this.user = user;
	}

	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdCard() {
		return idCard;
	}

	public void setIdCard(int idCard) {
		this.idCard = idCard;
	}

	public String getNumCard() {
		return numCard;
	}

	public void setNumCard(String numCard) {
		this.numCard = numCard;
	}

	public String getdExpiration() {
		return dExpiration;
	}

	public void setdExpiration(String dExpiration) {
		this.dExpiration = dExpiration;
	}

	public int getCodeCard() {
		return codeCard;
	}

	public void setCodeCard(int codeCard) {
		this.codeCard = codeCard;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	


	
}
