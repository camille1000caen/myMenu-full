package sopra.myMenubackEnd.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name = "adresse")
public class Adresse {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(name = "Rue")
	@JsonView(Views.ViewCommon.class)
	private String rue;
	@Column(name = "CodePostal")
	@JsonView(Views.ViewCommon.class)
	private String codePostal;
	@Column(name = "Ville")
	@JsonView(Views.ViewCommon.class)
	private String ville;
	@Column(name = "Pays")
	@JsonView(Views.ViewCommon.class)
	private String pays;
	@Embedded
	@JsonView(Views.ViewCommon.class)
	private Coordonnees coordonnees;
	@ManyToOne
	@JoinColumn(name = "Utilisateur_Id")
	@JsonView(Views.ViewAdresseWithUtilisateur.class)
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "Magasin_Id")
	@JsonView(Views.ViewAdresseWithMagasin.class)
	private Magasin magasin;
	
	public Adresse() {
		super();
	}

	public Adresse(String rue,String codePostal, String ville, String pays) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.pays = pays;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Magasin getMagasin() {
		return magasin;
	}

	public void setMagasin(Magasin magasin) {
		this.magasin = magasin;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", pays=" + pays + "]";
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
	
	
	
	
}
