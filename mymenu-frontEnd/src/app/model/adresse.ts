import {Utilisateur} from "./utilisateur";
import {Coordonnees} from "./coordonnees";
<<<<<<< HEAD
//import {Magasin} from "./magasin";
=======

>>>>>>> Camille

export class Adresse {
  id: number;
  version: number;

  rue: string;
  complement: string;
  codePostal: string;
  ville: string;
  pays: string;
  coordonnees:Coordonnees;
  utilisateur:Utilisateur;
<<<<<<< HEAD
  //magasin:Magasin;


  constructor(id?: number, version?: number, rue?: string, complement?: string, codePostal?: string, ville?: string, pays?: string,coordonnees?:Coordonnees) {
=======



  constructor(id?: number, version?: number, rue?: string, complement?: string, codePostal?: string, ville?: string, pays?: string,coordonnees?:Coordonnees,utilisateur?:Utilisateur) {
>>>>>>> Camille
    this.id = id!;
    this.version = version!;
    this.rue = rue!;
    this.complement = complement!;
    this.codePostal = codePostal!;
    this.ville=ville!;
    this.pays = pays!;
    this.coordonnees = coordonnees!;
<<<<<<< HEAD
=======
    this.utilisateur = utilisateur!;
>>>>>>> Camille
  }

}
