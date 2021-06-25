package sopra.myMenubackEnd.model;

public class Views {
	
	public static class ViewCommon {}
	
	public static class ViewAdresse extends ViewCommon {}
	
	public static class ViewAdresseWithMagasin extends ViewAdresse {}
	
	public static class ViewAdresseWithUtilisateur extends ViewAdresse {}
	
	public static class ViewUtilisateur extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaire extends ViewCommon {}
	
	public static class ViewPreferenceAlimentaireWithUtilisateur extends ViewPreferenceAlimentaire {}
	
	
	public static class ViewListeCourse extends ViewCommon{}
	
	public static class ViewListeCourseWithAjustement extends ViewListeCourse{}
	
	public static class ViewMagasin extends ViewCommon{}
	
	public static class ViewMagasinWithMagasinIngredient extends ViewMagasin{}
	
	public static class ViewAjustementQuantite extends ViewCommon{}
	
	public static class ViewMagasinIngredient extends ViewCommon{}
	
//	----------------------------------------------------------------------------------------- ViewPlanning
	
	public static class ViewPlanning extends ViewCommon{}
	
	public static class ViewPlanningWithObjectif extends ViewPlanning{}
	
	public static class ViewPlanningWithUtilisateur extends ViewPlanning{}
	
//	----------------------------------------------------------------------------------------- ViewMenu
	
	public static class ViewMenu extends ViewCommon{}
	
	public static class ViewMenuWithPlanning extends ViewMenu{}
	
//	----------------------------------------------------------------------------------------- ViewRepas
	
	public static class ViewRepas extends ViewCommon{}
	
	public static class ViewRepasWithTypeRepas extends ViewRepas{}
	
	public static class ViewRepasWithMenu extends ViewRepas{}
	
//	----------------------------------------------------------------------------------------- ViewObjectif
	
	public static class ViewObjectif extends ViewCommon{}
	
	public static class ViewObjectifWithTypeObjectif extends ViewObjectif{}
	
//	-----------------------------------------------------------------------------------------
	
	public static class ViewIngredient extends ViewCommon{}
	
	public static class ViewPlat extends ViewCommon{}
	
	public static class ViewRecette extends ViewCommon{}
	
	 
	
}
