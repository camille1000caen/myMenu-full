export class FormulaireDTO {
  creation: boolean = true;
  nom: string;
  prenom: string;
  dateNaissance: string;
  genre: string;
  telephone: string;
  email: string;
  username: string;
  password: string;
  poids: number;
  taille: number;
  imc: number;
  physicalActivity: string;
  typeAlimentation: string;
  typeObjectif: string;
  nbRepasJour: number;

  constructor(nom?: string, prenom?: string, dateNaissance?: string, telephone?: string, email?: string, username?: string, password?: string, poids?: number, taille?: number, imc?: number, physicalActivity?: string, typeAlimentation?: string, typeObjectif?: string, nbRepasJour?: number) {
    this.nom = nom!;
    this.prenom = prenom!;
    this.dateNaissance = dateNaissance!;
    this.telephone = telephone!;
    this.email = email!;
    this.username = username!;
    this.password = password!;
    this.poids = poids!;
    this.taille = taille!;
    this.imc = imc!;
    this.physicalActivity = physicalActivity!;
    this.typeAlimentation = typeAlimentation!;
    this.typeObjectif = typeObjectif!;
    this.nbRepasJour = nbRepasJour!;
  }

  public dtNaissanceToDate(): Date {
    return new Date(this.dateNaissance);
  }
}
