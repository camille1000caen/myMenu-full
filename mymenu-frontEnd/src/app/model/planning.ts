export class Planning {
  id: number;
  version: number;
  periode: number;

  constructor(id?: number, version?: number, periode?: number) {
    this.id = id!;
    this.version = version!;
    this.periode = periode!;
  }

}
