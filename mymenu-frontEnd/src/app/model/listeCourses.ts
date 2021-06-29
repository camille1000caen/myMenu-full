import {AjustementQuantite} from "./ajustementQuantite";
import {Recette} from "./recette";

// export class ListeCourses{
//   id : number;
//   ajustementQuantite : AjustementQuantite;
//
//   constructor(id?:number){
//     this.id=id!;
//   }
// }
export class ListeCourses {
  id: number;
  version: number;
  nom: string;
  quantite: number;
  typeProduit: string;
  produitSaison: string;
  recette: Recette;


  constructor(id?: number, version?: number, nom?: string, quantite?: number, typeProduit?: string, produitSaison?: string) {
    this.id = id!;
    this.version = version!;
    this.nom = nom!;
    this.quantite = quantite!;
    this.typeProduit = typeProduit!;
    this.produitSaison = produitSaison!;
  }
}
