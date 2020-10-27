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
@Table(name="cities")
public class City {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCity;
	
	@ManyToOne
	@JoinColumn(name ="idDistrict")
	private District District;

	@Column(name = "nameCity", length = 36, nullable = false)
	private String nameCity;

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}

	public City(int idCity, pe.edu.upc.entity.District district, String nameCity) {
		super();
		this.idCity = idCity;
		District = district;
		this.nameCity = nameCity;
	}

	public int getIdCity() {
		return idCity;
	}

	public void setIdCity(int idCity) {
		this.idCity = idCity;
	}

	public District getDistrict() {
		return District;
	}

	public void setDistrict(District district) {
		District = district;
	}

	public String getNameCity() {
		return nameCity;
	}

	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}



}
