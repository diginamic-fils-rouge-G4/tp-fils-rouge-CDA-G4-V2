import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, Subscription} from "rxjs";
import {TopicDTO} from "../dto/forum-dto";
import {Topic} from "../entities/Topic";

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  BASE_URL: string = "http://localhost:8080/"
  constructor(private http: HttpClient) { }

  getAll(id: number): Observable<Topic[]> {
    return this.http.get<Topic[]>(this.BASE_URL + "topics/" + id)
  }

  create(topic: TopicDTO): Observable<Topic> {
    return this.http.post<Topic>(this.BASE_URL + "topics", topic)
  }
  getOne(id: number): Observable<Topic> {
    return this.http.get<Topic>(this.BASE_URL + "topics/" + id)
  }

  updateOne(topic: TopicDTO): Observable<Topic> {
    return this.http.patch<Topic>(this.BASE_URL + "topics", topic)
  }

  deleteOne(id: number): Observable<Topic> {
    return this.http.delete<Topic>(this.BASE_URL + "topics/" + id)
  }
}
