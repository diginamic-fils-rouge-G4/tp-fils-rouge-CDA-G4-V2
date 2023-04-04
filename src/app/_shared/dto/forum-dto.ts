import {Rubrique} from "../entities/Rubrique";
import {Utilisateur} from "../entities/Utilisateur";

export interface RubriqueDTO {
  libelle?: string
}

export interface TopicDTO {
  libelle?: string
  rubrique?: Rubrique
  Utilisateur?: Utilisateur
}

export interface PostDTO {
  content?: string
  topicId?: number
  utilisateurId?: number
  createdDate?: Date
  updatedDate?: Date
}
