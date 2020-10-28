
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
@Table(name = "locations")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idLocation;

	@ManyToOne
	@JoinColumn(name = "idCity")
	private City City;
	
	@ManyToOne
	@JoinColumn(name = "idDistrict")
	private District District;
	                                                                      
             
	@Column(name = "nameDirection", length = 36, nullable = false)
	private String nameDirection;

	@Column(name = "numPostalCode", length = 36, nullable = false)
	private int numPostalCode;

	public Location() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Location(int idLocation, pe.edu.upc.entity.City city, pe.edu.upc.entity.District district,
			String nameDirection, int numPostalCode) {
		super();
		this.idLocation = idLocation;
		City = city;
		District = district;
		this.nameDirection = nameDirection;
		this.numPostalCode = numPostalCode;
	}


	public int getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}

	public City getCity() {
		return City;
	}

	public void setCity(City city) {
		City = city;
	}

	public District getDistrict() {
		return District;
	}

	public void setDistrict(District district) {
		District = district;
	}

	public String getNameDirection() {
		return nameDirection;
	}

	public void setNameDirection(String nameDirection) {
		this.nameDirection = nameDirection;
	}

	public int getNumPostalCode() {
		return numPostalCode;
	}

	public void setNumPostalCode(int numPostalCode) {
		this.numPostalCode = numPostalCode;
	}

	
}