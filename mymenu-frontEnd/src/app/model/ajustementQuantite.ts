export class AjustementQuantite{
  id : number;
  version : number;
  nombrePersonne : number;

  constructor( id? : number, version? :number, nombrePersonne? : number){
    this.id=id!;
    this.version=version!;
    this.nombrePersonne=nombrePersonne!;
  }
}
