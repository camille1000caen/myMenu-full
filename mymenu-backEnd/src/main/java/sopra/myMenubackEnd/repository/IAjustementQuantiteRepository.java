package sopra.myMenubackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import sopra.myMenubackEnd.model.AjustementQuantite;



public interface IAjustementQuantiteRepository extends JpaRepository<AjustementQuantite, Long> {

//	@Query("select l from ListeCourse l left join fetch l.ajustementQuantite")
//	@Query("select a from AjustementQuantite a INNER JOIN a.ingredient i ")
//	List<AjustementQuantite> findAllWithIngredient();

}
