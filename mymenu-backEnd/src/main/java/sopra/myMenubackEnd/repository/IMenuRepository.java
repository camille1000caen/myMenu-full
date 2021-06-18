package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Menu;

public interface IMenuRepository extends JpaRepository<Menu, Long>{

	@Query("select distinct m from Menu m WHERE m.planning.id =:idPlanning")
	List<Menu> findAllMenusByPlanning(@Param("idPlanning") Long idPlanning);
	
	@Query("select distinct m from Menu m left join fetch m.planning WHERE m.planning IS NOT NULL")
	List<Menu> findAllMenusWithPlanning();
	
	@Query("select distinct m from Menu m left join fetch m.planning where m.id = :id")
	Optional<Menu> findMenuByIdWithPlanning(@Param("id") Long id);
	
}
