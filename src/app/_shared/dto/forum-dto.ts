export interface RubriqueDTO {
  libelle?: string
}

export interface TopicDTO {
  libelle?: string
  rubriqueId?: number
  UtilisateurId?: number
}

export interface PostDTO {
  content?: string
  topicId?: number
  utilisateurId?: number
}
