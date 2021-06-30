package sopra.myMenubackEnd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;


@Entity
@Table(name = "recette")
public class Recette {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "nom")
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@Column(name = "etapes")
	@JsonView(Views.ViewCommon.class)
	@Lob
	private String etapes;
	@Column(name = "nombre_pers")
	@JsonView(Views.ViewCommon.class)
	private int nombrePers;
	@Column(name = "total_calories")
	private int totalCalories;
	@Column(name = "note")
	@JsonView(Views.ViewCommon.class)
	private Float note;
	@Column(name = "photo")
	@JsonView(Views.ViewCommon.class)
	private String photo;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeAlimentation typeAlimentation;
	@ManyToMany	(mappedBy="recettes")
	private List<Ingredient> ingredients = new ArrayList<Ingredient>();
	@ManyToOne
	@JsonView(Views.ViewRecetteDetail.class)
	private Plat plat;
	
	public Recette() {
		super();
	}

	public Recette(String nom, String etapes, int nombrePers, int totalCalories,Float note, TypeAlimentation typeAlimentation,String photo) {
		super();
		this.nom = nom;
		this.etapes = etapes;
		this.nombrePers = nombrePers;
		this.totalCalories = totalCalories;
		this.note = note;
		this.typeAlimentation = typeAlimentation;
		this.photo=photo;
		
	}

	public Float getNote() {
		return note;
	}

	public void setNote(Float note) {
		this.note = note;
	}
	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEtapes() {
		return etapes;
	}

	public void setEtapes(String etapes) {
		this.etapes = etapes;
	}

	public int getNombrePers() {
		return nombrePers;
	}

	public void setNombrePers(int nombrePers) {
		this.nombrePers = nombrePers;
	}

	public int getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}	

	public TypeAlimentation getTypeRecette() {
		return typeAlimentation;
	}

	public void setTypeRecette(TypeAlimentation typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public TypeAlimentation getTypeAlimentation() {
		return typeAlimentation;
	}

	public void setTypeAlimentation(TypeAlimentation typeAlimentation) {
		this.typeAlimentation = typeAlimentation;
	}

	public Plat getPlat() {
		return plat;
	}

	public void setPlat(Plat plat) {
		this.plat = plat;
	}
	
	
	

}
