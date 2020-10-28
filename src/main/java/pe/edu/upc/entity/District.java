package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="districts")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idDistrict;
	@Column(name = "nameDistrict", length=35 ,nullable = false)
	private String nameDistrict;
	
	@ManyToOne
	@JoinColumn(name = "idCity")
	private City City;
	
	
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}


	public District(int idDistrict, String nameDistrict, pe.edu.upc.entity.City city) {
		super();
		this.idDistrict = idDistrict;
		this.nameDistrict = nameDistrict;
		City = city;
	}


	public int getIdDistrict() {
		return idDistrict;
	}


	public void setIdDistrict(int idDistrict) {
		this.idDistrict = idDistrict;
	}


	public String getNameDistrict() {
		return nameDistrict;
	}


	public void setNameDistrict(String nameDistrict) {
		this.nameDistrict = nameDistrict;
	}


	public City getCity() {
		return City;
	}


	public void setCity(City city) {
		City = city;
	}

	
}
