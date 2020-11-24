package pe.edu.upc.entity;
 
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;


@Entity
@Table(name ="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;
	
	
	@Column(name="mPrice")
	private Double mprice;


	@Column(name = "nProduct", length = 45, nullable = false )

	private String nProduct;
	
	
	@Column(name = "qProduct")
	private int qProduct;
	
	@Column(name = "numWeigt", length = 65, nullable = false )
	private String numWeigt;
	
	@ManyToOne
	@JoinColumn(name = "idBrand")
	private Brand brand;
	
	@ManyToOne
	@JoinColumn(name="idStore")
	private Store store;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int idProduct, Category category, Double mprice, String nProduct, int qProduct, String numWeigt,
			Brand brand, Store store) {
		super();
		this.idProduct = idProduct;
		this.category = category;
		this.mprice = mprice;
		this.nProduct = nProduct;
		this.qProduct = qProduct;
		this.numWeigt = numWeigt;
		this.brand = brand;
		this.store = store;
	}


	public int getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(int idProduct) {
		this.idProduct = idProduct;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public Double getMprice() {
		return mprice;
	}


	public void setMprice(Double mprice) {
		this.mprice = mprice;
	}


	public String getnProduct() {
		return nProduct;
	}


	public void setnProduct(String nProduct) {
		this.nProduct = nProduct;
	}


	public int getqProduct() {
		return qProduct;
	}


	public void setqProduct(int qProduct) {
		this.qProduct = qProduct;
	}


	public String getNumWeigt() {
		return numWeigt;
	}


	public void setNumWeigt(String numWeigt) {
		this.numWeigt = numWeigt;
	}


	public Brand getBrand() {
		return brand;
	}


	public void setBrand(Brand brand) {
		this.brand = brand;
	}


	public Store getStore() {
		return store;
	}


	public void setStore(Store store) {
		this.store = store;
	}

		
}
