export class Objectif {
  id: number;
  version: number;
  typeObjectif: string;
  commentaire: string;
  nombreRepasParJour: number;
  nombreCaloriesParSemaine: number;

  constructor(id?: number, version?: number, typeObjectif?: string, commentaire?: string, nombreRepasParJour?: number, nombreCaloriesParSemaine?: number) {
    this.id = id!;
    this.version = version!;
    this.typeObjectif = typeObjectif!;
    this.commentaire = commentaire!;
    this.nombreRepasParJour = nombreRepasParJour!;
    this.nombreCaloriesParSemaine = nombreCaloriesParSemaine!;
  }

}
