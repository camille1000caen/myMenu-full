import {Utilisateur} from "./utilisateur";

export class PreferenceAlimentaire {
  id: number;
  version: number;
  typeAlimentation:string;
  utilisateur:Utilisateur;


  constructor(id?: number, version?: number, typeAlimentation?: string) {
    this.id = id!;
    this.version = version!;
    this.typeAlimentation = typeAlimentation!;
  }

}
