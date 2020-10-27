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
@Table(name ="products")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idProduct;
	
	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Category category;
	
	private Double Mprice;

	@Column(name = "nProduct", length = 45, nullable = false )
	private String nProduct;

	@Column(name = "qProduct", length = 55, nullable = false )
	private String qProduct;
	
	@Column(name = "numWeigt", length = 65, nullable = false )
	private String numWeigt;
	
	@ManyToOne
	@JoinColumn(name = "idBrand")
	private Brand brand;
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Product(int idProduct, Category category,
			@Max(value = 1000, message = "No se permite ingresar valores superiores a S/.1000") @Min(value = 1, message = "No se permite ingresar valores inferiores a S/.1") Double mprice,
			String nProduct, String qProduct, String numWeigt, Brand brand) {
		super();
		this.idProduct = idProduct;
		this.category = category;
		Mprice = mprice;
		this.nProduct = nProduct;
		this.qProduct = qProduct;
		this.numWeigt = numWeigt;
		this.brand = brand;
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
		return Mprice;
	}


	public void setMprice(Double mprice) {
		Mprice = mprice;
	}


	public String getnProduct() {
		return nProduct;
	}


	public void setnProduct(String nProduct) {
		this.nProduct = nProduct;
	}


	public String getqProduct() {
		return qProduct;
	}


	public void setqProduct(String qProduct) {
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
	
}
