package sopra.myMenubackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Plat;
import sopra.myMenubackEnd.model.TypeRepas;



public interface IPlatRepository extends JpaRepository <Plat,Long>{
	@Query("select distinct p from Plat p where p.repas= :repas")
	List<Plat>findAllByRepas(@Param("idRepas")Long idRepas);
	
	@Query("select distinct p from Plat p left join fetch p.repas")
	List<Plat>findAllWithRepas();
	
	@Query("select distinct p from Plat p left join fetch p.recette")
	List<Plat>findAllWithRecette();
	
	@Query("select distinct p from Plat p left join fetch p.recette left join fetch p.repas")
	List<Plat>findAllWithRecetteAndRepas();
	
	@Query("select distinct p from Plat p left join fetch p.repas where p.repas.typeRepas=:typeRepas")
	List<Plat>findAllWithRepasByTypeRepas(@Param("typeRepas")TypeRepas typeRepas);
	
}
