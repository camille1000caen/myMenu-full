import {AjustementQuantite} from "./ajustementQuantite";

export class ListeCourses{
  id : number;
  ajustementQuantite : AjustementQuantite;

  constructor(id?:number){
    this.id=id!;
  }
}
