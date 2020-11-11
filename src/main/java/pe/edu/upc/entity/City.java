package pe.edu.upc.entity;
import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCity;
	

	@Column(name = "nameCity", length = 36, nullable = false)
	@Pattern(regexp = "^[A-Za-z]*$", message="introduzca solo letras")
	private String nameCity;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int idCity, String nameCity) {
		super();
		this.idCity = idCity;
		this.nameCity = nameCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

}