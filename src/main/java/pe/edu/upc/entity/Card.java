package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCard;

	@Column(name = "numCard", length = 35 ,nullable = false)
	private String numCard;
	
	@Column(name = "dExpiration", length = 45, nullable = false)
	private String dExpiration;
	
	@Column(name = "codeCard", length = 55, nullable = false)
	private String codeCard;
	
	public Card() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Card(int idCard, String numCard, String dExpiration, String codeCard) {
		super();
		this.idCard = idCard;
		this.numCard = numCard;
		this.dExpiration = dExpiration;
		this.codeCard = codeCard;
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

	public String getCodeCard() {
		return codeCard;
	}

	public void setCodeCard(String codeCard) {
		this.codeCard = codeCard;
	}
	
	
	
	
}
