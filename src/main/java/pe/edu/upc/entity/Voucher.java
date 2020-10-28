package pe.edu.upc.entity;
import java.util.Date;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "voucher")


public class Voucher {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int idVoucher;

@NotNull(message = "La fecha es obligatoria")
@Past(message = "La fecha debe ser pasada")
@DateTimeFormat(pattern = "yyyy-MM-dd")
@Column(name = "birthDateLaboratory")
@Temporal(TemporalType.TIMESTAMP)
private Date dateVoucher;

private Double mTotalprice;

@ManyToOne
@JoinColumn(name = "idCard")
private Card card;

@ManyToOne
@JoinColumn(name = "idStore")
private Store store;

@ManyToOne
@JoinColumn(name = "idReserve")
private Reserve reserve;

@ManyToOne
@JoinColumn(name = "idProduct")
private Product product;

public Voucher() {
	super();
	// TODO Auto-generated constructor stub
}

public Voucher(int idVoucher,
		@NotNull(message = "La fecha es obligatoria") @Past(message = "La fecha debe ser pasada") Date dateVoucher,
		Double mTotalprice, Card card, Store store, Reserve reserve, Product product) {
	super();
	this.idVoucher = idVoucher;
	this.dateVoucher = dateVoucher;
	this.mTotalprice = mTotalprice;
	this.card = card;
	this.store = store;
	this.reserve = reserve;
	this.product = product;
}

public int getIdVoucher() {
	return idVoucher;
}

public void setIdVoucher(int idVoucher) {
	this.idVoucher = idVoucher;
}

public Date getDateVoucher() {
	return dateVoucher;
}

public void setDateVoucher(Date dateVoucher) {
	this.dateVoucher = dateVoucher;
}

public Double getmTotalprice() {
	return mTotalprice;
}

public void setmTotalprice(Double mTotalprice) {
	this.mTotalprice = mTotalprice;
}

public Card getCard() {
	return card;
}

public void setCard(Card card) {
	this.card = card;
}

public Store getStore() {
	return store;
}

public void setStore(Store store) {
	this.store = store;
}

public Reserve getReserve() {
	return reserve;
}

public void setReserve(Reserve reserve) {
	this.reserve = reserve;
}

public Product getProduct() {
	return product;
}

public void setProduct(Product product) {
	this.product = product;
}




}



//by el pepe
//idvoucher fecha precio total