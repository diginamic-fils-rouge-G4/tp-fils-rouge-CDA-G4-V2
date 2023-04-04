import {Utilisateur} from "./Utilisateur";
import {Topic} from "./Topic";

export class Post {
  private _id: number
  private _content: string
  private _utilisateur: Utilisateur
  private _topic: Topic
  private _createdDate: string
  private _updatedDate: string


  constructor(id: number, content: string, utilisateur: Utilisateur, topic: Topic, createdDate: string, updatedDate: string) {
    this._id = id;
    this._content = content;
    this._utilisateur = utilisateur;
    this._topic = topic;
    this._createdDate = createdDate;
    this._updatedDate = updatedDate;
  }


  get id(): number {
    return this._id;
  }

  set id(value: number) {
    this._id = value;
  }

  get content(): string {
    return this._content;
  }

  set content(value: string) {
    this._content = value;
  }

  get utilisateur(): Utilisateur {
    return this._utilisateur;
  }

  set utilisateur(value: Utilisateur) {
    this._utilisateur = value;
  }

  get topic(): Topic {
    return this._topic;
  }

  set topic(value: Topic) {
    this._topic = value;
  }

  get createdDate(): string {
    return this._createdDate;
  }

  set createdDate(value: string) {
    this._createdDate = value;
  }

  get updatedDate(): string {
    return this._updatedDate;
  }

  set updatedDate(value: string) {
    this._updatedDate = value;
  }
}
