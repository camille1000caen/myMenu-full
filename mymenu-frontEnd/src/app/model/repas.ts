import {Menu} from "./menu";

export class Repas {
  id: number;
  version: number;
  typeRepas: string;
  menu:Menu;

  constructor(id?: number, version?: number, typeRepas?: string) {
    this.id = id!;
    this.version = version!;
    this.typeRepas = typeRepas!;
  }

}
