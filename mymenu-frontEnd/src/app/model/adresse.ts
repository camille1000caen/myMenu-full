import {Utilisateur} from "./utilisateur";
import {Coordonnees} from "./coordonnees";
<<<<<<< HEAD
<<<<<<< HEAD
//import {Magasin} from "./magasin";
=======

>>>>>>> Camille
=======

>>>>>>> Solenn

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
<<<<<<< HEAD
  //magasin:Magasin;


  constructor(id?: number, version?: number, rue?: string, complement?: string, codePostal?: string, ville?: string, pays?: string,coordonnees?:Coordonnees) {
=======
=======
>>>>>>> Solenn



  constructor(id?: number, version?: number, rue?: string, complement?: string, codePostal?: string, ville?: string, pays?: string,coordonnees?:Coordonnees,utilisateur?:Utilisateur) {
<<<<<<< HEAD
>>>>>>> Camille
=======
>>>>>>> Solenn
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
<<<<<<< HEAD
>>>>>>> Camille
=======

>>>>>>> Solenn
  }

}
