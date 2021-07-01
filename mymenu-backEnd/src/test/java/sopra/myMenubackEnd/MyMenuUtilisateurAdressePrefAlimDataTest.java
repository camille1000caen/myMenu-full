package sopra.myMenubackEnd;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.PersistenceException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.myMenubackEnd.model.Adresse;
import sopra.myMenubackEnd.model.Coordonnees;
import sopra.myMenubackEnd.model.Genre;
import sopra.myMenubackEnd.model.PhysicalActivity;
import sopra.myMenubackEnd.model.PreferenceAlimentaire;
import sopra.myMenubackEnd.model.TypeAlimentation;
import sopra.myMenubackEnd.model.Utilisateur;
import sopra.myMenubackEnd.repository.IAdresseRepository;
import sopra.myMenubackEnd.repository.IPreferenceAlimentaireRepository;
import sopra.myMenubackEnd.repository.IUtilisateurRepository;

@SpringBootTest
public class MyMenuUtilisateurAdressePrefAlimDataTest {
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
				tom.setEmail("tom.favrot@soprasteria.com");
				tom.setTelephone("0666736382");
				tom.setPassword("Lesuperambassadeur");
				tom.setEnable(true);
				tom.setUsername("TompasThomas");
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
				baptiste.setEmail("baptiste.dessandier@soprasteria.com");
				baptiste.setTelephone("0624472830");
				baptiste.setPassword("Milou0203");
				baptiste.setEnable(true);
				baptiste.setUsername("THE FLASH");
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
				Solenn.setEmail("solenn.stefanski@gmail.com");
				Solenn.setTelephone(null);
				Solenn.setPassword(null);
				Solenn.setEnable(true);
				Solenn.setUsername(null);
		// CREATION UTILISATEUR
				Utilisateur Camille = new Utilisateur();
				try {
					Camille.setDateNaissance(sdf.parse("1993-01-01"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Camille.setGenre(Genre.FEMME);
				Camille.setImc(8.0F);
				Camille.setNom("1000CAEN");
				Camille.setPrenom("KMILLE");
				Camille.setPhysicalActivity(PhysicalActivity.OCCASIONNEL);
				Camille.setPoids(51.5F);
				Camille.setTaille(190.0F);
				tom.setEmail(null);
				tom.setTelephone(null);
				tom.setPassword(null);
				tom.setEnable(true);
				tom.setUsername(null);
				
		// CREATION UTILISATEUR
				Utilisateur Geoffrey = new Utilisateur();
				try {
					Geoffrey.setDateNaissance(sdf.parse("1994-01-18"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Geoffrey.setGenre(Genre.NON_BINAIRE);
				Geoffrey.setImc(18.0F);
				Geoffrey.setNom("Canron");
				Geoffrey.setPrenom("Geoffrey");
				Geoffrey.setPhysicalActivity(PhysicalActivity.OCCASIONNEL);
				Geoffrey.setPoids(74.5F);
				Geoffrey.setTaille(185.5F);
				tom.setEmail(null);
				tom.setTelephone(null);
				tom.setPassword(null);
				tom.setEnable(true);
				tom.setUsername(null);
		// CREATION UTILISATEUR
				Utilisateur Seif = new Utilisateur();
				try {
					Seif.setDateNaissance(sdf.parse("1996-02-28"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Seif.setGenre(Genre.HOMME);
				Seif.setImc(8.0F);
				Seif.setNom("Boulkroun");
				Seif.setPrenom("Seif");
				Seif.setPhysicalActivity(PhysicalActivity.REGULIER);
				Seif.setPoids(79.5F);
				Seif.setTaille(182.0F);
				tom.setEmail(null);
				tom.setTelephone(null);
				tom.setPassword(null);
				tom.setEnable(true);
				tom.setUsername(null);
		// CREATION UTILISATEUR
				Utilisateur Aubeline = new Utilisateur();
				try {
					Aubeline.setDateNaissance(sdf.parse("1994-09-14"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Aubeline.setGenre(Genre.FEMME);
				Aubeline.setImc(14.0F);
				Aubeline.setNom("Pecque");
				Aubeline.setPrenom("Aubeline");
				Aubeline.setPhysicalActivity(PhysicalActivity.INTENSIF);
				Aubeline.setPoids(54.5F);
				Aubeline.setTaille(155.0F);
				tom.setEmail(null);
				tom.setTelephone(null);
				tom.setPassword(null);
				tom.setEnable(true);
				tom.setUsername(null);
		// CREATION UTILISATEUR
				Utilisateur Lea = new Utilisateur();
				try {
					Lea.setDateNaissance(sdf.parse("1996-02-25"));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Lea.setGenre(Genre.FEMME);
				Lea.setImc(8.0F);
				Lea.setNom("Dumont");
				Lea.setPrenom("Lea");
				Lea.setPhysicalActivity(PhysicalActivity.PANTOUFLARD);
				Lea.setPoids(46.5F);
				Lea.setTaille(150.0F);
				tom.setEmail(null);
				tom.setTelephone(null);
				tom.setPassword(null);
				tom.setEnable(true);
				tom.setUsername(null);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimgeof = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

				prefAlimgeof.setUtilisateur(Geoffrey);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimseif = new PreferenceAlimentaire(TypeAlimentation.FLEXITARIEN, null);

				prefAlimseif.setUtilisateur(Seif);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimaube = new PreferenceAlimentaire(TypeAlimentation.VEGAN, null);

				prefAlimaube.setUtilisateur(Aubeline);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimlea = new PreferenceAlimentaire(TypeAlimentation.HALAL, null);

				prefAlimlea.setUtilisateur(Aubeline);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimbat = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

				prefAlimbat.setUtilisateur(baptiste);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimtom = new PreferenceAlimentaire(TypeAlimentation.FLEXITARIEN, null);

				prefAlimtom.setUtilisateur(tom);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimsol = new PreferenceAlimentaire(TypeAlimentation.VEGAN, null);

				prefAlimsol.setUtilisateur(Solenn);
				
		// CREATION PREF ALIM
				PreferenceAlimentaire prefAlimcam = new PreferenceAlimentaire(TypeAlimentation.HALAL, null);

				prefAlimcam.setUtilisateur(Camille);

		// CREATION ADRESSE
				Adresse adrgeoffrey = new Adresse("11 rue Electro Depot", "11000", "Carcassonne", "France");
				// adr.setUtilisateur(tom);
				adrgeoffrey.setCoordonnees(new Coordonnees(4.2, 88.4));
				adrgeoffrey.setUtilisateur(Geoffrey);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adrseif = new Adresse("22 rue Brico Depot", "22000", "Culey", "France");
				// adr.setUtilisateur(tom);
				adrseif.setCoordonnees(new Coordonnees(4.9, 87.6));
				adrseif.setUtilisateur(Seif);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adraube = new Adresse("77 rue Monsieur Bricolage", "77000", "Melun", "France");
				// adr.setUtilisateur(tom);
				adraube.setCoordonnees(new Coordonnees(4.7, 87.5));
				adraube.setUtilisateur(Aubeline);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adrlea = new Adresse("99 rue Castorama", "99000", "Monaco", "France");
				// adr.setUtilisateur(tom);
				adrlea.setCoordonnees(new Coordonnees(4.5, 86.5));
				adrlea.setUtilisateur(Lea);
				// tom.addAdresse(adr);
				
				
		// CREATION ADRESSE
				Adresse adrbat = new Adresse("11 rue Electro Depot", "11000", "Carcassonne", "France");
				// adr.setUtilisateur(tom);
				adrbat.setCoordonnees(new Coordonnees(4.2, 88.4));
				adrbat.setUtilisateur(baptiste);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adrtom = new Adresse("22 rue Brico Depot", "22000", "Culey", "France");
				// adr.setUtilisateur(tom);
				adrseif.setCoordonnees(new Coordonnees(4.9, 87.6));
				adrseif.setUtilisateur(tom);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adrsol = new Adresse("77 rue Monsieur Bricolage", "77000", "Melun", "France");
				// adr.setUtilisateur(tom);
				adrsol.setCoordonnees(new Coordonnees(4.7, 87.5));
				adrsol.setUtilisateur(Solenn);
				// tom.addAdresse(adr);
				
		// CREATION ADRESSE
				Adresse adrcam = new Adresse("99 rue Castorama", "99000", "Monaco", "France");
				// adr.setUtilisateur(tom);
				adrcam.setCoordonnees(new Coordonnees(4.5, 86.5));
				adrcam.setUtilisateur(Camille);
				// tom.addAdresse(adr);
				try {

					tom = utilisateurRepo.save(tom);
					prefAlimtom = prefAlimRepo.save(prefAlimtom);
					adrtom = adresseRepo.save(adrtom);
					
					Solenn = utilisateurRepo.save(Solenn);
					prefAlimsol = prefAlimRepo.save(prefAlimsol);
					adrsol = adresseRepo.save(adrsol);
					
					Camille = utilisateurRepo.save(Camille);
					prefAlimcam = prefAlimRepo.save(prefAlimcam);
					adrcam = adresseRepo.save(adrcam);
					
					
					baptiste = utilisateurRepo.save(baptiste);
					prefAlimbat = prefAlimRepo.save(prefAlimtom);
					adrbat = adresseRepo.save(adrtom);
					
					Geoffrey = utilisateurRepo.save(Geoffrey);
					prefAlimgeof = prefAlimRepo.save(prefAlimgeof);
					adrgeoffrey = adresseRepo.save(adrgeoffrey);
					
					Seif = utilisateurRepo.save(Seif);
					prefAlimseif = prefAlimRepo.save(prefAlimseif);
					adrseif = adresseRepo.save(adrseif);
					
					
					Aubeline = utilisateurRepo.save(Aubeline);
					prefAlimaube = prefAlimRepo.save(prefAlimaube);
					adraube = adresseRepo.save(adraube);
					
					Lea = utilisateurRepo.save(Lea);
					prefAlimlea = prefAlimRepo.save(prefAlimlea);
					adrlea = adresseRepo.save(adrlea);
					
				} catch (PersistenceException e) {
				}

	}
}	
