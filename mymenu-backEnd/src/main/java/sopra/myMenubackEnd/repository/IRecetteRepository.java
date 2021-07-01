package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Recette;
import sopra.myMenubackEnd.model.TypeAlimentation;
import sopra.myMenubackEnd.model.TypeRepas;




public interface IRecetteRepository extends JpaRepository<Recette, Long>{
	
	@Query("select r from Recette r where r.nom= :nom") 
	List<Recette> findByName(@Param("nom") String nom);
	
//	@Query("select r from Recette r ORDER BY r.totalCalories ASC")
//	List<Recette> findByRisingCalories();
	
	@Query("select r from Recette r where r.note= :note")
	List<Recette> findByNote(@Param("note") float note);

	@Query("select r from Recette r ORDER BY r.note DESC")
	List<Recette> findByRisingNote();

	@Query("select r from Recette r where r.typeAlimentation= :typeAlimentation")
	List<Recette> findByTypeAlimentation(@Param("typeAlimentation")TypeAlimentation typeAlimentation);
	
	@Query("select distinct r from Recette r WHERE r.plat.id =:id")
	List<Recette> findAllRecetteByPlat(@Param("id") Long id);
	
	@Query("select distinct r from Recette r left join fetch r.plat WHERE r.plat IS NOT NULL")
	List<Recette> findAllRecetteWithPlat();
	
	@Query("select distinct r from Recette r left join fetch r.plat where r.id = :id")
	Optional<Recette> findRecetteByIdWithPlat(@Param("id") Long id);
	
	@Query("select r from Recette r left join fetch r.plat ORDER BY r.note DESC")
	List<Recette> findByRisingNoteWithPlat();
	
	@Query("select r from Recette r left join fetch r.plat p join p.repas re WHERE re.typeRepas=:typeRepas ORDER BY r.note DESC")
	List<Recette> findByRisingNoteWithPlatByTypeRepas(@Param("typeRepas")TypeRepas typeRepas);
	
	@Query("select r from Recette r left join fetch r.plat pt left join fetch pt.repas rep where r.id=:id")
	Optional<Recette> findByIdWithPlatAndRepas(@Param("id") Long id);
	
}
