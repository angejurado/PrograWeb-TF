package pe.edu.upc.entity;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;

	@Column(name = "nameCategory", length = 50, nullable = false)
	@Pattern(regexp = "[a-zA-Z ]{2,254}", message="introduzca solo letras")
	private String nameCategory;

//CONSTRUCTOR
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int idCategory, String nameCategory) {
	super();
	this.idCategory = idCategory;
	this.nameCategory = nameCategory;
	}

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

	
	
}
