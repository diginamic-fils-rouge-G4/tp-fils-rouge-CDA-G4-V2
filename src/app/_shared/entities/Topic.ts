import {Rubrique} from "./Rubrique";
import {Utilisateur} from "./Utilisateur";

export class Topic {
  private _id: number
  private _libelle: string
  private _rubrique: Rubrique
  private _Utilisateur: Utilisateur


  constructor(id: number, libelle: string, rubrique: Rubrique, Utilisateur: Utilisateur) {
    this._id = id;
    this._libelle = libelle;
    this._rubrique = rubrique;
    this._Utilisateur = Utilisateur;
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

  get rubrique(): Rubrique {
    return this._rubrique;
  }

  set rubrique(value: Rubrique) {
    this._rubrique = value;
  }

  get utilisateur(): Utilisateur {
    return this._Utilisateur;
  }

  set utilisateur(value: Utilisateur) {
    this._Utilisateur = value;
  }
}
