package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Planning;

	public interface IPlanningRepository extends JpaRepository<Planning, Long> {
		
		@Query("select distinct p from Planning p WHERE p.objectif.id =:idObjectif")
		List<Planning> findAllPlanningsByObjectif(@Param("idObjectif") Long idObjectif);
		
		@Query("select distinct p from Planning p left join fetch p.objectif WHERE p.objectif IS NOT NULL")
		List<Planning> findAllPlanningsWithObjectif();
		
		@Query("select distinct p from Planning p left join fetch p.objectif where p.id = :id")
		Optional<Planning> findPlanningByIdWithObjectif(@Param("id") Long id);
		
		@Query("select distinct p from Planning p WHERE p.utilisateur.id =:idUtilisateur")
		List<Planning> findAllPlanningsByUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
		
		@Query("select distinct p from Planning p left join fetch p.utilisateur WHERE p.utilisateur IS NOT NULL")
		List<Planning> findAllPlanningsWithUtilisateur();
		
		@Query("select distinct p from Planning p left join fetch p.utilisateur where p.id = :id")
		Optional<Planning> findPlanningByIdWithUtilisateur(@Param("id") Long id);
}
