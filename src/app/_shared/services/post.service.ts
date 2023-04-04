import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {PostDTO, TopicDTO} from "../dto/forum-dto";
import {Subscription} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PostService {
  BASE_URL: string = "http://localhost:8080/"
  constructor(private http: HttpClient) { }
  getAllTopics(): Subscription {
    return this.http.get(this.BASE_URL + "posts").subscribe()
  }
  createPost(post: PostDTO): void {
    this.http.post(this.BASE_URL + "posts", post).subscribe()
  }
  deleteOnePost(id: number): void {
    this.http.delete(this.BASE_URL + "posts/" + id).subscribe()
  }
}
