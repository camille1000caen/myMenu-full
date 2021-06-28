package sopra.myMenubackEnd;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Genre;
import sopra.myMenubackEnd.model.PhysicalActivity;
import sopra.myMenubackEnd.model.Utilisateur;
import sopra.myMenubackEnd.repository.IAdresseRepository;
import sopra.myMenubackEnd.repository.IPreferenceAlimentaireRepository;
import sopra.myMenubackEnd.repository.IUtilisateurRepository;

@SpringBootTest
public class MyMenuUtilisateurDataTest {
	@Autowired
	IUtilisateurRepository utilisateurRepo;
	@Autowired
	IAdresseRepository adresseRepo;
	@Autowired
	IPreferenceAlimentaireRepository prefAlimRepo;
	
	@Test
	public void Utilisateurfill() {
		// CREATION UTILISATEUR
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Utilisateur tom = new Utilisateur();
				try {
					tom.setDateNaissance(sdf.parse("1994-05-10"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tom.setGenre(Genre.NON_BINAIRE);
				tom.setImc(18.0F);
				tom.setNom("Favrot");
				tom.setPrenom("Tom");
				tom.setPhysicalActivity(PhysicalActivity.PANTOUFLARD);
				tom.setPoids(77.5F);
				tom.setTaille(177.5F);
		// CREATION UTILISATEUR
				Utilisateur baptiste = new Utilisateur();
				try {
					baptiste.setDateNaissance(sdf.parse("1995-10-28"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				baptiste.setGenre(Genre.HOMME);
				baptiste.setImc(10.0F);
				baptiste.setNom("Dessandier");
				baptiste.setPrenom("Baptiste");
				baptiste.setPhysicalActivity(PhysicalActivity.REGULIER);
				baptiste.setPoids(81.5F);
				baptiste.setTaille(175.0F);
		// CREATION UTILISATEUR
				Utilisateur Solenn = new Utilisateur();
				try {
					Solenn.setDateNaissance(sdf.parse("1995-08-14"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Solenn.setGenre(Genre.FEMME);
				Solenn.setImc(14.0F);
				Solenn.setNom("Stefanski");
				Solenn.setPrenom("Solenn");
				Solenn.setPhysicalActivity(PhysicalActivity.INTENSIF);
				Solenn.setPoids(54.5F);
				Solenn.setTaille(155.0F);
		// CREATION UTILISATEUR
				Utilisateur Camille = new Utilisateur();
				try {
					Solenn.setDateNaissance(sdf.parse("1995-08-14"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Solenn.setGenre(Genre.FEMME);
				Solenn.setImc(14.0F);
				Solenn.setNom("Stefanski");
				Solenn.setPrenom("Solenn");
				Solenn.setPhysicalActivity(PhysicalActivity.INTENSIF);
				Solenn.setPoids(54.5F);
				Solenn.setTaille(155.0F);

	}
}	