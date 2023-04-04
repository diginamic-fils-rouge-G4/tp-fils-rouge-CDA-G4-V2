import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Subscription} from "rxjs";
import {TopicDTO} from "../dto/forum-dto";

@Injectable({
  providedIn: 'root'
})
export class TopicService {
  BASE_URL: string = "http://localhost:8080/"
  constructor(private http: HttpClient) { }

  getAllTopics(): Subscription {
    return this.http.get(this.BASE_URL + "topics").subscribe()
  }

  createTopic(topic: TopicDTO): void {
    this.http.post(this.BASE_URL + "topics", topic).subscribe()
  }
  getOneTopic(id: number): Subscription {
    return this.http.get(this.BASE_URL + "topics/" + id).subscribe()
  }

  updateOneTopic(topic: TopicDTO): void {
    this.http.patch(this.BASE_URL + "topics", topic).subscribe()
  }

  deleteOneTopic(id: number): void {
    this.http.delete(this.BASE_URL + "topics/" + id).subscribe()
  }
}
