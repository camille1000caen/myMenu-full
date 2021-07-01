package sopra.myMenubackEnd.service;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import sopra.myMenubackEnd.model.Genre;
import sopra.myMenubackEnd.model.PhysicalActivity;
import sopra.myMenubackEnd.model.TypeAlimentation;
import sopra.myMenubackEnd.model.TypeObjectif;

public class FormulaireDTO {
	private String nom;
	private String prenom;
	private Genre genre;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateNaissance ;
	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	private String telephone;
	private String email;
	private String username;
	private String password;
	private Float poids;
	private Float taille;
	private Float imc;
	private PhysicalActivity physicalActivity;
	private TypeAlimentation typeAlimentation;
	private TypeObjectif typeObjectif;
	private Integer NbRepasJour;
	
	public FormulaireDTO(String nom, String prenom, Date dateNaissance, String telephone, String email, String password,String username,
			Float poids, Float taille, Float imc, PhysicalActivity physicalActivity, TypeAlimentation typeAlimentation,
			TypeObjectif typeObjectif,Integer NbRepasJour) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.telephone = telephone;
		this.email = email;
		this.password = password;
		this.poids = poids;
		this.taille = taille;
		this.imc = imc;
		this.physicalActivity = physicalActivity;
		this.typeAlimentation = typeAlimentation;
		this.typeObjectif = typeObjectif;
		this.username=username;
		this.NbRepasJour=NbRepasJour;
	}

	public Integer getNbRepasJour() {
		return NbRepasJour;
	}

	public void setNbRepasJour(Integer nbRepasJour) {
		NbRepasJour = nbRepasJour;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public FormulaireDTO() {
		super();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Float getPoids() {
		return poids;
	}

	public void setPoids(Float poids) {
		this.poids = poids;
	}

	public Float getTaille() {
		return taille;
	}

	public void setTaille(Float taille) {
		this.taille = taille;
	}

	public Float getImc() {
		return imc;
	}

	public void setImc(Float imc) {
		this.imc = imc;
	}

	public PhysicalActivity getPhysicalActivity() {
		return physicalActivity;
	}

	public void setPhysicalActivity(PhysicalActivity physicalActivity) {
		this.physicalActivity = physicalActivity;
	}

	public TypeAlimentation getTypeAlimentation() {
		return typeAlimentation;
	}

	public void setTypeAlimentation(TypeAlimentation typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}

	public TypeObjectif getTypeObjectif() {
		return typeObjectif;
	}

	public void setTypeObjectif(TypeObjectif typeObjectif) {
		this.typeObjectif = typeObjectif;
	}
	
	
	

}
