package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Repas;
import sopra.myMenubackEnd.model.TypeRepas;

public interface IRepasRepository extends JpaRepository<Repas, Long>{

	@Query("select r from Repas r where r.typeRepas= :typeRepas")
	List<Repas> findAllRepasByTypeRepas(@Param("typeRepas") TypeRepas typeRepas);
	
	@Query("select distinct r from Repas r WHERE r.menu.id =:idMenu")
	List<Repas> findAllRepasByMenu(@Param("idMenu") Long idMenu);
	
	@Query("select distinct r from Repas r left join fetch r.menu WHERE r.menu IS NOT NULL")
	List<Repas> findAllRepasWithMenu();
	
	@Query("select distinct r from Repas r left join fetch r.menu where r.id = :id")
	Optional<Repas> findRepasByIdWithMenu(@Param("id") Long id);
	
}
