package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="districts")
public class District {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int idDistrict;
	@Column(name = "nameDistrict", length=35 ,nullable = false)
	private String nameDistrict;
	public District() {
		super();
		// TODO Auto-generated constructor stub
	}
	public District(int idDistrict, String nameDistrict) {
		super();
		this.idDistrict = idDistrict;
		this.nameDistrict = nameDistrict;
	}
	// Get and set
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
	
}
