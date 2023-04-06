import {Rubrique} from "../entities/Rubrique";
import {Utilisateur} from "../entities/Utilisateur";

export interface RubriqueDTO {
  libelle?: string
  nbrTopics?: number
}

export interface RubriqueUpdateDTO {
  id?:number,
  libelle?: string
}

export interface TopicUpdateDTO {
  id?:number,
  libelle?: string
  rubrique?: number
}

export interface TopicExportDTO {
  libelle?: string
  rubrique?: number
  utilisateur?: string
}

export interface TopicDTO {
  id?: number
  libelle?: string
  rubrique?: Rubrique
  Utilisateur?: Utilisateur
}

export interface PostDTO {
  content?: string
  topic?: number
  utilisateur?: string
  createdDate?: Date
  updatedDate?: Date
}

export interface PostUpdateDTO {
  id?: number,
  content?: string
}

