package sopra.myMenubackEnd.model;

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

@Entity
@Table(name = "plat")
public class Plat {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(name = "nombre_personne")
	private int nombrePersonne;
	@ManyToOne
	@JoinColumn(name = "repas_id")
	private Repas repas;
	@OneToMany(mappedBy = "plat")
	private List<Recette> recette;
	
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
	
}
