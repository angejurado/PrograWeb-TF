package pe.edu.upc.entity;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;




@Entity
@Table(name="reserves")
public class Reserve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReserve;
		
	@ManyToOne
	@JoinColumn(name="idUser")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="idStore")
	private Store store;
	
	@ManyToOne
    @JoinColumn(name="idCard")
    private Card card;	

	@Column(name = "dDate", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dDate;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "idReserve", nullable = true)
	private List<DetailsReserve> reserveDetails;
	
	
	
	@PrePersist
	public void prePersist() {
		
		this.dDate = new Date();
	}

	public Double getTotal() {
		return reserveDetails.stream().collect(Collectors.summingDouble(DetailsReserve::calcularSubTotal));
	}

	public void addDetailImportation(DetailsReserve item) {
		this.reserveDetails.add(item);
	}


	public Long getIdReserve() {
		return idReserve;
	}

	public void setIdReserve(Long idReserve) {
		this.idReserve = idReserve;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public Date getdDate() {
		return dDate;
	}

	public void setdDate(Date requestday) {
		this.dDate = requestday;
	}

	public List<DetailsReserve> getReserveDetails() {
		return reserveDetails;
	}

	public void setReserveDetails(List<DetailsReserve> reserveDetails) {
		this.reserveDetails = reserveDetails;
	}




		
}