export class AjustementQuantite{
  id : number;
  version : number;
 quantiteModifiee : number;

  constructor( id? : number, version? :number, quantiteModifiee? : number){
    this.id=id!;
    this.version=version!;
    this.quantiteModifiee=quantiteModifiee!;
  }
}
