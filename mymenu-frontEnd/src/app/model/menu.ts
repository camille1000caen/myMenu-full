import {Planning} from "./planning";

export class Menu {
  id: number;
  version: number;
  jour: string;
  planning:Planning;

  constructor(id?: number, version?: number, jour?: string) {
    this.id = id!;
    this.version = version!;
    this.jour = jour!;
  }

  public jourToDate() : Date {
    return new Date(this.jour);
  }
}
