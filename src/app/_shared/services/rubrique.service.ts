import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subscription} from "rxjs";
import {RubriqueDTO} from "../dto/forum-dto";
import {Rubrique} from "../entities/Rubrique";

@Injectable({
  providedIn: 'root'
})
export class RubriqueService {
  BASE_URL: string = "http://localhost:8080/"
  constructor(private http: HttpClient) { }

  getAllRubrique(): Observable<Rubrique[]> {
    return this.http.get<Rubrique[]>(this.BASE_URL + "rubriques")
  }

  createRubrique(rubrique: RubriqueDTO): Observable<void> {
    return this.http.post<void>(this.BASE_URL + "rubriques", rubrique)
  }

  getOneRubrique(id: number): Observable<Rubrique> {
    return this.http.get<Rubrique>(this.BASE_URL + "rubriques/" + id)
  }

  deleteOneRubrique(id: number): Observable<void> {
    return this.http.delete<void>(this.BASE_URL + "rubriques/" + id)
  }
}
