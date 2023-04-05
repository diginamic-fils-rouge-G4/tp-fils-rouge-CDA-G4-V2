import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TopicService} from "../../../../../_shared/services/topic.service";
import {RubriqueService} from "../../../../../_shared/services/rubrique.service";
import {Topic} from "../../../../../_shared/entities/Topic";
import {PostDTO, RubriqueDTO, TopicDTO, TopicExportDTO} from "../../../../../_shared/dto/forum-dto";
import {PostService} from "../../../../../_shared/services/post.service";
import {Post} from "../../../../../_shared/entities/Post";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {JwtTokenService} from "../../../../../_shared/services/jwt-token.service";

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  topicId: any
  topic: TopicDTO = {}
  posts: Post[] = []
  post: PostDTO = {}
  rubrique: RubriqueDTO = {}
  form = new FormGroup({
    content: new FormControl('', Validators.minLength(3))
  });

  constructor(
    private route: ActivatedRoute,
    private topicService: TopicService,
    private rubriqueService: RubriqueService,
    private postService: PostService,
    private tokenService: JwtTokenService
  ) { }

  ngOnInit(): void {
    this.getAllPosts()
    this.getCurrentTopic(this.topicId)
  }

  getAllPosts() {
    this.topicId = this.route.snapshot.params['id']
    this.postService.getAll(this.topicId).subscribe(res => {
      this.posts = res
    })
  }

  getCurrentTopic(id: number) {
    this.topicService.getOne(id).subscribe(res => {
      console.log(res)
      this.topic = res
      this.rubrique = res.rubrique
    })
  }

  createPost() {
    if(this.form.valid) {
      this.post.content = this.form.value.content
      this.post.topic = this.topicId
      this.post.utilisateur = this.tokenService.getUserMail()
      this.postService.create(this.post).subscribe(() => {
        this.ngOnInit()
      })
    }
  }

  deletePost(id: number) {
    this.postService.deleteOne(id).subscribe(() => {
      this.ngOnInit()
    })
  }

  updatePost(post: PostDTO) {
    this.postService.updateOne(post).subscribe(() => {
      this.ngOnInit()
    })
  }
}
