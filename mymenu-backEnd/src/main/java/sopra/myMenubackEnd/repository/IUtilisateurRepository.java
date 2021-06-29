package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sopra.myMenubackEnd.model.Genre;
import sopra.myMenubackEnd.model.PhysicalActivity;
import sopra.myMenubackEnd.model.Utilisateur;



public interface IUtilisateurRepository extends JpaRepository<Utilisateur,Long> {
	
	@Query("select distinct u from Utilisateur u where u.email = :email")
	List<Utilisateur> findAllByEmail(@Param("email") String email);
	
	@Query("select distinct u from Utilisateur u where u.telephone = :telephone")
	List<Utilisateur> findAllByTelephone(@Param("telephone") String telephone);
	
	@Query("select distinct u from Utilisateur u where u.imc = :imc")
	List<Utilisateur> findAllByImc(@Param("imc") Float imc);
	
	@Query("select distinct u from Utilisateur u where u.physicalActivity = :physicalActivity")
	List<Utilisateur> findAllByPhysicalActivity(@Param("physicalActivity") PhysicalActivity physicalActivity);
	
	@Query("select distinct u from Utilisateur u where u.genre = :genre")
	List<Utilisateur> findAllByGenre(@Param("genre") Genre genre);
	
	@Query("select distinct u from Utilisateur u where u.nom = :nom and u.prenom = :prenom")
	List<Utilisateur> findAllByNomAndPrenom(@Param("nom") String nom,@Param("prenom") String prenom);
	
	@Query("select distinct u from Utilisateur u left join fetch u.roles where u.username = :username")
	Optional<Utilisateur> findByIdWithRoles(@Param("username") String username);
	
	@Query("select u from Utilisateur u where u.username = :username or and u.email:=email and u.password =:password ")
	Optional<Utilisateur> findByConn(@Param("username") String username,@Param("email") String email,@Param("password") String password);
}
