import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PostDTO, TopicDTO} from "../dto/forum-dto";
import {Observable, Subscription} from "rxjs";
import {Post} from "../entities/Post";

@Injectable({
  providedIn: 'root'
})
export class PostService {
  BASE_URL: string = "http://localhost:8080/"
  constructor(private http: HttpClient) { }
  getAll(id: number): Observable<Post[]> {
    return this.http.get<Post[]>(this.BASE_URL + "posts/" + id)
  }
  create(post: PostDTO): Observable<Post> {
    return this.http.post<Post>(this.BASE_URL + "posts", post)
  }
  deleteOne(id: number): Observable<Post> {
    return this.http.delete<Post>(this.BASE_URL + "posts/" + id)
  }

  updateOne(post: PostDTO): Observable<Post> {
    return this.http.patch<Post>(this.BASE_URL + "posts", post)
  }
}
