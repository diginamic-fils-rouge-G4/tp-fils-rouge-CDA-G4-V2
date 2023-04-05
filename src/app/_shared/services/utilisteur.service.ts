import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Utilisateur} from "../entities/Utilisateur";

@Injectable({
  providedIn: 'root'
})
export class UtilisteurService {

  BASE_URL: string = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  getAll(): Observable<Utilisateur[]> {
    return this.http.get<Utilisateur[]>(this.BASE_URL + "utilisateurs")
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(this.BASE_URL + "utilisateurs/" + id)
  }

}
