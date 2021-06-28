package sopra.myMenubackEnd.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "objectifs")
public class Objectif {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeObjectif typeObjectif;
	@Column(name = "commentaire")
	@JsonView(Views.ViewCommon.class)
	private String commentaire;
	@Column(name = "nombreRepasParJour")
	@JsonView(Views.ViewCommon.class)
	private int nombreRepasParJour;
	@Column(name = "nombreCaloriesParSemaine")
	@JsonView(Views.ViewCommon.class)
	private int nombreCaloriesParSemaine;

	
	public Objectif() {
		super();
	}
	
	public Objectif(Long id, int version, TypeObjectif typeObjectif, String commentaire, int nombreRepasParJour,
			int nombreCaloriesParSemaine) {
		super();
		this.id = id;
		this.version = version;
		this.typeObjectif = typeObjectif;
		this.commentaire = commentaire;
		this.nombreRepasParJour = nombreRepasParJour;
		this.nombreCaloriesParSemaine = nombreCaloriesParSemaine;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeObjectif getTypeObjectif() {
		return typeObjectif;
	}

	public void setTypeObjectif(TypeObjectif typeObjectif) {
		this.typeObjectif = typeObjectif;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getNombreRepasParJour() {
		return nombreRepasParJour;
	}

	public void setNombreRepasParJour(int nombreRepasParJour) {
		this.nombreRepasParJour = nombreRepasParJour;
	}

	public int getNombreCaloriesParSemaine() {
		return nombreCaloriesParSemaine;
	}

	public void setNombreCaloriesParSemaine(int nombreCaloriesParSemaine) {
		this.nombreCaloriesParSemaine = nombreCaloriesParSemaine;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
