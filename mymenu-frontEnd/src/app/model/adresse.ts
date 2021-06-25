import {Utilisateur} from "./utilisateur";
import {Coordonnees} from "./coordonnees";
import {Magasin} from "./magasin";

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
  magasin:Magasin;


  constructor(id?: number, version?: number, rue?: string, complement?: string, codePostal?: string, ville?: string, pays?: string,coordonnees?:Coordonnees,utilisateur?:Utilisateur,magasin?:Magasin) {
    this.id = id!;
    this.version = version!;
    this.rue = rue!;
    this.complement = complement!;
    this.codePostal = codePostal!;
    this.ville=ville!;
    this.pays = pays!;
    this.coordonnees = coordonnees!;
    this.utilisateur = utilisateur!;
    this.magasin = magasin!;
  }
  
}
