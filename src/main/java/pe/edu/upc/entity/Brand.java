package pe.edu.upc.entity;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="brands")
public class Brand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBrand;
	
	@Column(name = "nameBrand", length = 35, nullable = false)
	@Pattern(regexp = "[a-zA-Z]{2,80}", message="Introduzca solo letras en la marca")
	private String nameBrand;
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Brand(int idBrand, String nameBrand) {
		super();
		this.idBrand = idBrand;
		this.nameBrand = nameBrand;
	}
	
	// Get and set
	public int getIdBrand() {
		return idBrand;
	}
	public void setIdBrand(int idBrand) {
		this.idBrand = idBrand;
	}
	public String getNameBrand() {
		return nameBrand;
	}
	public void setNameBrand(String nameBrand) {
		this.nameBrand = nameBrand;
	}
	
	
	//MICHAEL
	
}
