package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.PreferenceAlimentaire;
import sopra.myMenubackEnd.model.TypeAlimentation;



public interface IPreferenceAlimentaireRepository extends JpaRepository<PreferenceAlimentaire,Long> {

	@Query("select distinct p from PreferenceAlimentaire p where p.typeAlimentation = :typeAlimentation")
	List<PreferenceAlimentaire> findAllByTypeAlimentation(@Param("typeAlimentation") TypeAlimentation typeAlimentation);
	
	@Query("select distinct p from PreferenceAlimentaire p left join fetch p.utilisateur")
	List<PreferenceAlimentaire> findAllWithUtilisateur();
	
	@Query("select p from PreferenceAlimentaire p where p.utilisateur.id=:idUtilisateur")
	List<PreferenceAlimentaire> findAllByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
	
	@Query("select distinct p from PreferenceAlimentaire p left join fetch p.utilisateur where p.id = :id")
	Optional<PreferenceAlimentaire> findByIdWithUtilisateur(@Param("id") Long id);
	
}
