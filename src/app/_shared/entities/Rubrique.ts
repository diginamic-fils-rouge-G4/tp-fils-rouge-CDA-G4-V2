export class Rubrique {
  private _id: number
  private _libelle: string

  constructor(id: number, libelle: string) {
    this._id = id;
    this._libelle = libelle;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get libelle(): string {
    return this._libelle;
  }

  set libelle(value: string) {
    this._libelle = value;
  }
}
