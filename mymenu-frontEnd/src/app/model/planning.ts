import {Objectif} from "./objectif";
import {Utilisateur} from "./utilisateur";

export class Planning {
  id: number;
  version: number;
  periode: number;
  objectif:Objectif;
  utilisateur:Utilisateur;

  constructor(id?: number, version?: number, periode?: number) {
    this.id = id!;
    this.version = version!;
    this.periode = periode!;
  }

}
