package sopra.myMenubackEnd.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import sopra.myMenubackEnd.model.Ingredient;
import sopra.myMenubackEnd.model.ProduitSaison;
import sopra.myMenubackEnd.model.TypeProduit;



public interface IIngredientRepository extends JpaRepository<Ingredient, Long> {

	@Query("select i from Ingredient i where i.nom= :nom")
	Ingredient findIngredientByName(@Param("nom") String nom);
	
	@Query("select i from Ingredient i where i.produitSaison= :produitSaison")
	List<Ingredient> findIngredientByProduitSaison(@Param("produitSaison") ProduitSaison produitSaison);
	
	@Query("select i from Ingredient i where i.typeProduit= :typeProduit")
	List<Ingredient> findIngredientByTypeProduit(@Param("typeProduit") TypeProduit typeProduit);
	
	@Query("select i from Ingredient i left join fetch i.recettes r where r.id= :id")
	List<Ingredient> findAllIngredientByRecette(@Param("id") Long id);

	
	
}
