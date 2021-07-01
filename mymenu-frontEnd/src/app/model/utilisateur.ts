export class Utilisateur {
  id: number;
  version: number;
  username:string;
  password:string;
  enable:boolean;
  nom: string;
  prenom: string;
  email: string;
  telephone: string;
  poids:number;
  taille:number;
  dateNaissance:string;
  genre:string;
  imc:number;
  physicalActivity:string;




  constructor(id?: number, version?: number, nom?: string, prenom?: string, email?: string, telephone?: string, poids?: number,taille?:number,dateNaissance?:string,genre?:string,imc?:number,physicalActivity?:string,username?:string,password?:string,enable?:boolean) {
    this.id = id!;
    this.version = version!;
    this.nom = nom!;
    this.prenom = prenom!;
    this.email = email!;
    this.telephone = telephone!;
    this.poids = poids!;
    this.taille = taille!;
    this.dateNaissance = dateNaissance!;
    this.genre = genre!;
    this.imc = imc!;
    this.physicalActivity=physicalActivity!;
    this.username = username!;
    this.password = password!;
    this.enable=true;
  }

  public dtNaissanceToDate() : Date {
    return new Date(this.dateNaissance);
  }
}
