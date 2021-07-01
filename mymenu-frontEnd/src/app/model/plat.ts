import {Repas} from "./repas";

export class Plat {

  id:number;
  version:number;
  nombrePersonne:number;
  repas: Repas;

  constructor(id?:number,version?:number, nombrePersonne?:number) {
    this.id = id!;
    this.version = version!;
    this.nombrePersonne = nombrePersonne!;
  }

}
