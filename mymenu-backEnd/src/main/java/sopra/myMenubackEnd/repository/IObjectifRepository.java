package sopra.myMenubackEnd.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Objectif;
import sopra.myMenubackEnd.model.TypeObjectif;

public interface IObjectifRepository extends JpaRepository<Objectif, Long>{

	@Query("select o from Objectif o where o.typeObjectif= :typeObjectif")
	List<Objectif> findAllObjectifByTypeObjectif(@Param("typeObjectif") TypeObjectif typeObjectif);
	
}
