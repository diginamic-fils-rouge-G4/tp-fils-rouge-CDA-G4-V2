import {Rubrique} from "./Rubrique";
import {Utilisateur} from "./Utilisateur";

export class Topic {
  private _id: number
  private _libelle: string
  private _rubrique: Rubrique
  private _utilisateur: Utilisateur
  private _post: number


  constructor(id: number, libelle: string, rubrique: Rubrique, Utilisateur: Utilisateur, post: number) {
    this._id = id;
    this._libelle = libelle;
    this._rubrique = rubrique;
    this._utilisateur = Utilisateur;
    this._post = post;
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
    return this._utilisateur;
  }

  set utilisateur(value: Utilisateur) {
    this._utilisateur = value;
  }


  get post(): number {
    return this._post;
  }

  set post(value: number) {
    this._post = value;
  }
}
