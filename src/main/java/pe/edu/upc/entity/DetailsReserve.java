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
@Table(name="detailsreserves")
public class DetailsReserve {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDetailsReserve;
	
	@ManyToOne
	@JoinColumn(name="idProduct")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name="idStore")
	private Store store;
	
	@ManyToOne
	@JoinColumn(name="idReserve")
	private Reserve reserve;
	
	@Column(name="mprice")
	private double mprice;
	
	@Column(name="quantity")
	private int quantity;
	

}
