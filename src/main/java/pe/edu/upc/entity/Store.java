package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idStore;
	
	@Column(name = "nameBusiness", length = 35, nullable = false)
	private String nameBusiness;
	
	@Column(name = "starHour", length = 35, nullable = false)
	private String starHour;
	
	@Column(name = "endHour", length = 35, nullable = false)
	private String endHour;
	
	@Column(name = "tDescription", length = 35, nullable = false)
	private String tDescription;
	
	@ManyToOne
	@JoinColumn(name = "idLocation")
	private Location location;

	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Store(int idStore, String nameBusiness, String starHour, String endHour, String tDescription,
			Location location) {
		super();
		this.idStore = idStore;
		this.nameBusiness = nameBusiness;
		this.starHour = starHour;
		this.endHour = endHour;
		this.tDescription = tDescription;
		this.location = location;
	}

	public int getIdStore() {
		return idStore;
	}

	public void setIdStore(int idStore) {
		this.idStore = idStore;
	}

	public String getNameBusiness() {
		return nameBusiness;
	}

	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}

	public String getStarHour() {
		return starHour;
	}

	public void setStarHour(String starHour) {
		this.starHour = starHour;
	}

	public String getEndHour() {
		return endHour;
	}

	public void setEndHour(String endHour) {
		this.endHour = endHour;
	}

	public String gettDescription() {
		return tDescription;
	}

	public void settDescription(String tDescription) {
		this.tDescription = tDescription;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
}
