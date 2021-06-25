export class Planning {
  id: number;
  version: number;
  typeRepas: string;

  constructor(id?: number, version?: number, typeRepas?: string) {
    this.id = id!;
    this.version = version!;
    this.typeRepas = typeRepas!;
  }

}
