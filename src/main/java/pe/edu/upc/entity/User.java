package pe.edu.upc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUser;
	
	@Column(name="nameUser", length=100, nullable=false )
	private String nameUser;
	
	@Column(name = "emailUser",length = 100, nullable = false)
	private String emailUser;
	
	@Max(value=999999999, message="Ingrese un numero correcto")
	@Min(value=900000000, message="Ingrese un numero correcto")
	private int celUser;
	
	@Column(name="passwordUser", length=20, nullable=false)
	private String passwordUser;
	
	@Column(name="typeUser", nullable=false)
	private int typeUser;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int idUser, String nameUser, String emailUser,
			@Max(value = 999999999, message = "Ingrese un numero correcto") @Min(value = 900000000, message = "Ingrese un numero correcto") int celUser,
			String passwordUser, int typeUser) {
		super();
		this.idUser = idUser;
		this.nameUser = nameUser;
		this.emailUser = emailUser;
		this.celUser = celUser;
		this.passwordUser = passwordUser;
		this.typeUser = typeUser;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}

	public String getEmailUser() {
		return emailUser;
	}

	public void setEmailUser(String emailUser) {
		this.emailUser = emailUser;
	}

	public int getCelUser() {
		return celUser;
	}

	public void setCelUser(int celUser) {
		this.celUser = celUser;
	}

	public String getPasswordUser() {
		return passwordUser;
	}

	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}

	public int getTypeUser() {
		return typeUser;
	}

	public void setTypeUser(int typeUser) {
		this.typeUser = typeUser;
	}
	
	
	

}
