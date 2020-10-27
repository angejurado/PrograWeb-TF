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
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCategory;
	@ManyToOne
	@JoinColumn(name = "idStore", nullable = false)
	private Store Store;

	@Column(name = "nameCategory", length = 50, nullable = false)
	private String nameCategory;

//CONSTRUCTOR
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(int idCategory, pe.edu.upc.entity.Store store, String nameCategory) {
		super();
		this.idCategory = idCategory;
		Store = store;
		this.nameCategory = nameCategory;
	}
	// GET AND SET

	public int getIdCategory() {
		return idCategory;
	}

	public void setIdCategory(int idCategory) {
		this.idCategory = idCategory;
	}

	public Store getStore() {
		return Store;
	}

	public void setStore(Store store) {
		Store = store;
	}

	public String getNameCategory() {
		return nameCategory;
	}

	public void setNameCategory(String nameCategory) {
		this.nameCategory = nameCategory;
	}

}
