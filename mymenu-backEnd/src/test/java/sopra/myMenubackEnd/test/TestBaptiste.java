package sopra.myMenubackEnd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.PersistenceException;

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

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestBaptiste {

	@Autowired
	IUtilisateurRepository utilisateurRepo;
	@Autowired
	IAdresseRepository adresseRepo;
	@Autowired
	IPreferenceAlimentaireRepository prefAlimRepo;

	@Test
	public void utilisateurAdressePreferenceAlimentaireCreate() {

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

		// CREATION PREF ALIM
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

		// tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));

		// tom.addAdresse(adr);

		try {

			tom = utilisateurRepo.save(tom);
			prefAlim = prefAlimRepo.save(prefAlim);
			adr = adresseRepo.save(adr);

			// Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch (PersistenceException e) {
		}
		Utilisateur tomFind = utilisateurRepo.findById(tom.getId()).get();

		// TEST UTILISATEUR
		assertEquals(Genre.NON_BINAIRE, tomFind.getGenre());
		assertEquals(PhysicalActivity.PANTOUFLARD, tomFind.getPhysicalActivity());
		try {
			assertEquals(sdf.parse("1994-05-10"), tomFind.getDateNaissance());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(18.0F, tomFind.getImc(), 0.0F);
		assertEquals(77.5F, tomFind.getPoids(), 0.0F);
		assertEquals(177.5F, tomFind.getTaille(), 0.0F);

		assertEquals("Favrot", tomFind.getNom());
		assertEquals("Tom", tomFind.getPrenom());

		// TEST PREF ALIM
		PreferenceAlimentaire prefFind = prefAlimRepo.findById(prefAlim.getId()).get();
		assertEquals(TypeAlimentation.NONE, prefFind.getTypeAlimentation());

		// TEST ADRESSE
		Adresse adrFind = adresseRepo.findById(adr.getId()).get();

		System.out.println(adrFind.toString());

		assertEquals("33000", adrFind.getCodePostal());
		assertEquals("Residence plikepluck", adrFind.getComplement());
		assertEquals("33 rue IKEA", adrFind.getRue());
		assertEquals("France", adrFind.getPays());
		assertEquals("Bordeaux", adrFind.getVille());
		assertEquals(4.0, adrFind.getCoordonnees().getLongitude(), 0.0);
		assertEquals(88.0, adrFind.getCoordonnees().getLatitude(), 0.0);

		utilisateurRepo.delete(tomFind);
		utilisateurRepo.delete(tom);
		adresseRepo.delete(adrFind);
		adresseRepo.delete(adr);
		prefAlimRepo.delete(prefFind);
		prefAlimRepo.delete(prefAlim);
	}

	@Test
	public void utilisateurAdressePreferenceAlimentaireUpdate() {
		// CREATION UTILISATEUR
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
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

		// CREATION PREF ALIM
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);

		// tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));

		// tom.addAdresse(adr);

		try {

			tom = utilisateurRepo.save(tom);
			prefAlim = prefAlimRepo.save(prefAlim);
			adr = adresseRepo.save(adr);

			// Assert.fail("Vérification commentaires obligatoire en erreur");
		} catch (PersistenceException e) {
		}

		// TEST UTILISATEUR
		tom = utilisateurRepo.save(tom);
		tom = utilisateurRepo.findById(tom.getId()).get();

		tom.setGenre(Genre.HOMME);
		try {
			tom.setDateNaissance(sdf.parse("1874-01-14"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		tom.setImc(77.0F);
		tom.setNom("Favori");
		tom.setPhysicalActivity(PhysicalActivity.INTENSIF);
		tom.setPoids(67.5F);
		tom.setPrenom("Thomas");
		tom.setTaille(167.5F);

		tom = utilisateurRepo.save(tom);

		tom = utilisateurRepo.findById(tom.getId()).get();

		assertEquals(Genre.HOMME, tom.getGenre());
		assertEquals(PhysicalActivity.INTENSIF, tom.getPhysicalActivity());
		try {
			assertEquals(sdf.parse("1874-01-14"), tom.getDateNaissance());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(77.0F, tom.getImc(), 0.0F);
		assertEquals(67.5F, tom.getPoids(), 0.0F);
		assertEquals(167.5F, tom.getTaille(), 0.0F);

		assertEquals("Favori", tom.getNom());
		assertEquals("Thomas", tom.getPrenom());

		// TEST ADRESSE
		adr = adresseRepo.save(adr);
		adr = adresseRepo.findById(adr.getId()).get();

		adr.setCodePostal("33555");
		adr.setComplement("Residence Brook OEP Langedek");
		adr.setRue("33 rue HEMA");
		adr.setPays("Espagne");
		adr.setVille("SantaMariaPutaCruz");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(99.0, 35.0));

		adr = adresseRepo.save(adr);
		adr = adresseRepo.findById(adr.getId()).get();

		assertEquals("33555", adr.getCodePostal());
		assertEquals("Residence Brook OEP Langedek", adr.getComplement());
		assertEquals("33 rue HEMA", adr.getRue());
		assertEquals("Espagne", adr.getPays());
		assertEquals("SantaMariaPutaCruz", adr.getVille());
		assertEquals(99.0, adr.getCoordonnees().getLongitude(), 0.0);
		assertEquals(35.0, adr.getCoordonnees().getLatitude(), 0.0);

		// TEST PREF ALIM
		prefAlim = prefAlimRepo.save(prefAlim);
		prefAlim = prefAlimRepo.findById(prefAlim.getId()).get();

		prefAlim.setTypeAlimentation(TypeAlimentation.VEGAN);

		prefAlim = prefAlimRepo.save(prefAlim);
		prefAlim = prefAlimRepo.findById(prefAlim.getId()).get();

		assertEquals(TypeAlimentation.VEGAN, prefAlim.getTypeAlimentation());

		utilisateurRepo.delete(tom);
		prefAlimRepo.delete(prefAlim);
		adresseRepo.delete(adr);
	}

	@Test
	public void utilisateurAdressePreferenceAlimentaireFindall() {
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

		tom = utilisateurRepo.save(tom);

		Utilisateur emma = new Utilisateur();
		try {
			emma.setDateNaissance(sdf.parse("1994-10-15"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		emma.setGenre(Genre.FEMME);
		emma.setImc(9.0F);
		emma.setNom("Tome");
		emma.setPrenom("Emma");
		emma.setPhysicalActivity(PhysicalActivity.INTENSIF);
		emma.setPoids(55.5F);
		emma.setTaille(165.5F);

		emma = utilisateurRepo.save(emma);
		// CREATION PREF ALIM
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);
		prefAlim = prefAlimRepo.save(prefAlim);

		PreferenceAlimentaire prefAlim2 = new PreferenceAlimentaire(TypeAlimentation.VEGAN, null);
		prefAlim2 = prefAlimRepo.save(prefAlim2);
		// tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));
		adr = adresseRepo.save(adr);

		Adresse adr2 = new Adresse("44 rue H&M", "Residence Bamboula", "66666", "SatanVille", "Allemagne");
		adr2.setCoordonnees(new Coordonnees(77.0, 19.0));
		adr2 = adresseRepo.save(adr2);
		// tom.addAdresse(adr);

		// TEST UTILISATEUR
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();

		assertEquals(2, utilisateurs.size());

		utilisateurRepo.delete(tom);
		utilisateurRepo.delete(emma);

		// TEST PREF ALIM
		List<PreferenceAlimentaire> prefsalims = prefAlimRepo.findAll();

		assertEquals(2, prefsalims.size());

		prefAlimRepo.delete(prefAlim);
		prefAlimRepo.delete(prefAlim2);

		// TEST Adresse
		List<Adresse> adresses = adresseRepo.findAll();

		assertEquals(2, adresses.size());

		adresseRepo.delete(adr);
		adresseRepo.delete(adr2);

	}
	@Test
	public void utilisateurAdressePreferenceAlimentaireDelete() {
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

		tom = utilisateurRepo.save(tom);

		Utilisateur emma = new Utilisateur();
		try {
			emma.setDateNaissance(sdf.parse("1994-10-15"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		emma.setGenre(Genre.FEMME);
		emma.setImc(9.0F);
		emma.setNom("Tome");
		emma.setPrenom("Emma");
		emma.setPhysicalActivity(PhysicalActivity.INTENSIF);
		emma.setPoids(55.5F);
		emma.setTaille(165.5F);

		emma = utilisateurRepo.save(emma);
		// CREATION PREF ALIM
		PreferenceAlimentaire prefAlim = new PreferenceAlimentaire(TypeAlimentation.NONE, null);
		prefAlim = prefAlimRepo.save(prefAlim);

		PreferenceAlimentaire prefAlim2 = new PreferenceAlimentaire(TypeAlimentation.VEGAN, null);
		prefAlim2 = prefAlimRepo.save(prefAlim2);
		// tom.addPreferenceAlimentaire(prefAlim);

		// CREATION ADRESSE
		Adresse adr = new Adresse("33 rue IKEA", "Residence plikepluck", "33000", "Bordeaux", "France");
		// adr.setUtilisateur(tom);
		adr.setCoordonnees(new Coordonnees(4.0, 88.0));
		adr = adresseRepo.save(adr);

		Adresse adr2 = new Adresse("44 rue H&M", "Residence Bamboula", "66666", "SatanVille", "Allemagne");
		adr2.setCoordonnees(new Coordonnees(77.0, 19.0));
		adr2 = adresseRepo.save(adr2);
		// tom.addAdresse(adr);

		// TEST UTILISATEUR
		List<Utilisateur> utilisateurs = utilisateurRepo.findAll();

		assertEquals(2, utilisateurs.size());

		utilisateurRepo.delete(tom);
		utilisateurRepo.delete(emma);

		utilisateurs = utilisateurRepo.findAll();

		assertEquals(0, utilisateurs.size());

		// TEST PREF ALIM
		List<PreferenceAlimentaire> prefsalims = prefAlimRepo.findAll();

		assertEquals(2, prefsalims.size());

		prefAlimRepo.delete(prefAlim);
		prefAlimRepo.delete(prefAlim2);

		prefsalims = prefAlimRepo.findAll();

		assertEquals(0, prefsalims.size());

		// TEST Adresse
		List<Adresse> adresses = adresseRepo.findAll();

		assertEquals(2, adresses.size());

		adresseRepo.delete(adr);
		adresseRepo.delete(adr2);

		adresses = adresseRepo.findAll();

		assertEquals(0, adresses.size());

	}

}
