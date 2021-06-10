package sopra.myMenubackEnd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sopra.myMenubackEnd.model.Menu;



public interface IMenuRepository extends JpaRepository<Menu, Long>{

}
