import {Ingredient} from "./ingredient";

export class AjustementQuantite{
  id : number;
  version : number;
  quantiteModifiee : number;
  listeIngredients : Array<Ingredient>;

  constructor( id? : number, version? :number, quantiteModifiee? : number, listeIngredients?:Array<Ingredient>){
    this.id=id!;
    this.version=version!;
    this.quantiteModifiee=quantiteModifiee!;
  }
}
