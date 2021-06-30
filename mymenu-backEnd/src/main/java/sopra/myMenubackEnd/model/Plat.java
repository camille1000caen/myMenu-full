package sopra.myMenubackEnd.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "plat")
public class Plat {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "nombre_personne")
	@JsonView(Views.ViewCommon.class)
	private int nombrePersonne;
	@ManyToOne
	@JoinColumn(name = "repas_id")
	private Repas repas;
	@OneToMany(mappedBy = "plat")
	private List<Recette> recettes= new ArrayList<Recette>();
	
	

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}

	public Plat() {
		super();
	}
	
	public Plat(Long id, int version, int nombrePersonne) {
		super();
		this.id = id;
		this.version = version;
		this.nombrePersonne = nombrePersonne;
	}

	public Plat(int nombrePersonne) {
		super();
		this.nombrePersonne = nombrePersonne;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public int getNombrePersonne() {
		return nombrePersonne;
	}


	public void setNombrePersonne(int nombrePersonne) {
		this.nombrePersonne = nombrePersonne;
	}


	public Repas getRepas() {
		return repas;
	}


	public void setRepas(Repas repas) {
		this.repas = repas;
	}


	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}

	public List<Recette> getRecettes() {
		return recettes;
	}

	public void setRecettes(List<Recette> recettes) {
		this.recettes = recettes;
	}




	
	
	
}
