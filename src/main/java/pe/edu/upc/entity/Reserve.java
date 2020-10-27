package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reserves")
public class Reserve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idReserve;
	@Column(name = "nameReserve", length=35 ,nullable = false)
	private String nameReserve;
	public Reserve() {
		super();
		// TODO Auto-generated constructor stub
	}
	// constructor
	public Reserve(int idReserve, String nameReserve) {
		super();
		this.idReserve = idReserve;
		this.nameReserve = nameReserve;
	}
	// Get and set
	public int getIdReserve() {
		return idReserve;
	}
	public void setIdReserve(int idReserve) {
		this.idReserve = idReserve;
	}
	public String getNameReserve() {
		return nameReserve;
	}
	public void setNameReserve(String nameReserve) {
		this.nameReserve = nameReserve;
	}
	
}
