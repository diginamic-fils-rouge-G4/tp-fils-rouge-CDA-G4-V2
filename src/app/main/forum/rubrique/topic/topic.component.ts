import {Component, ElementRef, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TopicService} from "../../../../_shared/services/topic.service";
import {ActivatedRoute} from "@angular/router";
import {TopicExportDTO} from "../../../../_shared/dto/forum-dto";
import {Topic} from "../../../../_shared/entities/Topic";
import {RubriqueService} from "../../../../_shared/services/rubrique.service";
import {Rubrique} from "../../../../_shared/entities/Rubrique";
import {JwtTokenService} from "../../../../_shared/services/jwt-token.service";
import {Utilisateur} from "../../../../_shared/entities/Utilisateur";

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {
  addClass: boolean = false
  selectedId: any;
  rubriqueId: any
  topic: TopicExportDTO = {}
  rubrique: Rubrique = new Rubrique(0, "", 0)
  user: string = ""
  isVisitor: boolean = true

  topics: Topic[] = []

  form = new FormGroup({
    libelle: new FormControl('', Validators.minLength(3))
  });

  constructor(
    private elementRef: ElementRef,
    private topicService: TopicService,
    private route: ActivatedRoute,
    private rubriqueService: RubriqueService,
    private tokenService: JwtTokenService
  ) {
  }

  ngOnInit(): void {
    this.getAllTopics()
    this.getCurrentRubrique(this.rubriqueId)
    this.isVisitor = this.tokenService.isVisitor()
    const icon: any = document.querySelector('.ellipse')
    const navRubrique: any = document.querySelector('.nav-rubrique')
    icon.addEventListener('click', () => {
      navRubrique.classList.toggle('d-none')
      icon.classList.toggle('fa-ellipsis-vertical')
      icon.classList.toggle('fa-xmark')
    })
  }

  openVerticale(e: Event, id: number) {
    this.closeAllVerticaleButGivenId(id);
    this.selectedId = id
    const navTopics: any = document.getElementById("topic"+this.selectedId);
    const icon: any = document.getElementById("icon"+this.selectedId);
    const xicon: any = document.getElementById("Xicon"+this.selectedId);

    xicon.classList.remove('d-none')
    navTopics.classList.toggle('d-none')
    icon.classList.toggle('fa-ellipsis-vertical')
    icon.classList.toggle('invisible')
  }

  closeAllVerticaleButGivenId(id:number){
    for (let index = 0; index < this.topics.length; index++) {
      if (this.topics[index].id != id){
        const navRubrique: any = document.getElementById("topic"+this.topics[index].id);
        const icon: any = document.getElementById("icon"+this.topics[index].id);
        const xicon: any = document.getElementById("Xicon"+this.topics[index].id);

        xicon.classList.add('d-none')
        navRubrique.classList.add('d-none')
        navRubrique.classList.remove('nav-rubrique-visible')
        icon.classList.add('fa-ellipsis-vertical')
        icon.classList.remove('invisible')
      }
    }
  }
  closeVerticale(id:number) {
    this.selectedId = id
    const navTopics: any = document.getElementById("topic"+this.selectedId);
    const icons: any = document.getElementById("icon"+this.selectedId);
    const xicons: any = document.getElementById("Xicon"+this.selectedId);

    navTopics.classList.add('d-none')
    navTopics.classList.toggle('nav-rubrique-visible')
    icons.classList.add('fa-ellipsis-vertical')
    icons.classList.remove('d-none')
    xicons.classList.add('d-none')
  }

  canUpdateTopic(user: Utilisateur): boolean {
    return user.mail === this.tokenService.getUserMail();
  }

  getAllTopics() {
    this.rubriqueId = this.route.snapshot.params['id']
    this.topicService.getAll(this.rubriqueId).subscribe(res => {
      this.topics = res
    })
  }

  getCurrentRubrique(id: number) {
    this.rubriqueService.getOne(id).subscribe(res => {
      this.rubrique = res
    })
  }

  createTopic() {
    if (this.form.valid) {
      this.topic.libelle = this.form.value.libelle
      this.topic.rubrique = this.rubrique.id
      this.topic.utilisateur = this.tokenService.getUserMail()
      this.topicService.create(this.topic).subscribe(() => {
        this.ngOnInit()
      })
    }
  }

  deleteTopic(id: number) {
    this.topicService.deleteOne(id).subscribe(() => {
      this.ngOnInit()
    })
  }

  updateTopic(topic: TopicExportDTO) {
    this.topicService.updateOne(topic).subscribe(() => {
      this.ngOnInit()
    })
  }

}
