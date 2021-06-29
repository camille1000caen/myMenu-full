import {Ingredient} from "./ingredient";
import {Plat} from "./plat";

export class Recette {
  id: number;
  version:number;
  nom: string;
  etapes: string;
  nombrePers: number;
  typeRecette: string;
  photo: string;
  ingredient: Ingredient;
  plat:Plat;

  constructor(id?:number, version?:number, nom?:string, etapes?:string, nombrePers?:number, typeRecette?: string, photo?:string) {
    this.id = id!;
    this.version =version!;
    this.nom = nom!;
    this.etapes = etapes!;
    this.nombrePers = nombrePers!;
    this.typeRecette = typeRecette!;
    this.photo = photo!;
  }
}

