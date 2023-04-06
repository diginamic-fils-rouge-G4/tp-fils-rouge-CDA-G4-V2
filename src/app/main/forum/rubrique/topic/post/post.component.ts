import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {TopicService} from "../../../../../_shared/services/topic.service";
import {RubriqueService} from "../../../../../_shared/services/rubrique.service";
import {Topic} from "../../../../../_shared/entities/Topic";
import {
  PostDTO,
  PostUpdateDTO,
  RubriqueDTO,
  TopicDTO,
  TopicExportDTO,
  TopicUpdateDTO
} from "../../../../../_shared/dto/forum-dto";
import {PostService} from "../../../../../_shared/services/post.service";
import {Post} from "../../../../../_shared/entities/Post";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {JwtTokenService} from "../../../../../_shared/services/jwt-token.service";
import {Utilisateur} from "../../../../../_shared/entities/Utilisateur";

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

  editModalVisibility: boolean = false;

  modifiedPostId!: number
  modifiedPostContent!: string

  rubrique: RubriqueDTO = {}
  isVisitor: boolean = true

  form = new FormGroup({
    content: new FormControl('', Validators.minLength(3))
  });

  formEdit = new FormGroup({
    content: new FormControl('', Validators.minLength(3))
  });

  constructor(
    private route: ActivatedRoute,
    private topicService: TopicService,
    private rubriqueService: RubriqueService,
    private postService: PostService,
    private tokenService: JwtTokenService
  ) {
  }

  ngOnInit(): void {
    this.getAllPosts()
    this.getCurrentTopic(this.topicId)
    this.isVisitor = this.tokenService.isVisitor()
  }

  closeEditModal() {
    this.editModalVisibility = false;
  }

  openEditModal(id: number) {
    this.editModalVisibility = true;

    for (let index = 0; index < this.posts.length; index++) {
      if (this.posts[index].id == id) {
        this.modifiedPostId = this.posts[index].id;
        this.modifiedPostContent = this.posts[index].content;
      }
    }
  }

  getAllPosts() {
    this.topicId = this.route.snapshot.params['id']
    this.postService.getAll(this.topicId).subscribe(res => {
      this.posts = res
      console.log(this.posts)
    })
  }

  getCurrentTopic(id: number) {
    this.topicService.getOne(id).subscribe(res => {
      this.topic = res
      this.rubrique = res.rubrique
    })
  }

  canUpdateTopic(user: Utilisateur): boolean {
    return user.mail === this.tokenService.getUserMail();
  }

  createPost() {
    if (this.form.valid) {
      this.post.content = this.form.value.content
      this.post.topic = this.topicId
      this.post.utilisateur = this.tokenService.getUserMail()
      this.postService.create(this.post).subscribe(() => {
        this.form.reset()
        this.ngOnInit()
      })
    }
  }

  deletePost(id: number) {
    this.postService.deleteOne(id).subscribe(() => {
      this.ngOnInit()
    })
  }

  updatePost() {

    if (this.formEdit.valid) {
      let postToEdit: PostUpdateDTO = {}

      postToEdit.id = this.modifiedPostId
      postToEdit.content = this.formEdit.value.content

      console.log(postToEdit)

      this.postService.updateOne(postToEdit).subscribe(() => {
        this.ngOnInit()
      })
    }
    this.closeEditModal()

  }
}
