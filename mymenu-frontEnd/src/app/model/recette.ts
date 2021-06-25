import {Ingredient} from "./ingredient";

export class Recette {
  id: number;
  version:number;
  nom: string;
  etapes: string;
  nombrePers: number;
  typeRecette: string;
  photo: string;
  ingredient: Ingredient;

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

