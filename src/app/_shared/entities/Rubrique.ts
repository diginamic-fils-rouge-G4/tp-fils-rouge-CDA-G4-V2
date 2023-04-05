export class Rubrique {
  private _id: number
  private _libelle: string
  private _nbreTopics: number


  constructor(id: number, libelle: string, nbrTopics: number) {
    this._id = id;
    this._libelle = libelle;
    this._nbreTopics = nbrTopics;
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

  get nbreTopics(): number {
    return this._nbreTopics;
  }

  set nbreTopics(value: number) {
    this._nbreTopics = value;
  }
}
