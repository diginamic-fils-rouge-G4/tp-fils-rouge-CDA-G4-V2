import {Component, ElementRef, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {TopicService} from "../../../../_shared/services/topic.service";
import {ActivatedRoute} from "@angular/router";
import {TopicDTO} from "../../../../_shared/dto/forum-dto";
import {Topic} from "../../../../_shared/entities/Topic";
import {RubriqueService} from "../../../../_shared/services/rubrique.service";
import {Rubrique} from "../../../../_shared/entities/Rubrique";

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {
  addClass: boolean = false
  selectedId: any;
  rubriqueId: any
  topic: TopicDTO = {}
  rubrique: Rubrique = new Rubrique(0, "")

  topics: Topic[] = []

  form = new FormGroup({
    libelle: new FormControl('', Validators.minLength(3))
  });

  constructor(
    private elementRef: ElementRef,
    private topicService: TopicService,
    private route: ActivatedRoute,
    private rubriqueService: RubriqueService
  ) {
  }

  ngOnInit(): void {
    this.getAllTopics()
    this.getCurrentRubrique(this.rubriqueId)
    const icon: any = document.querySelector('.ellipse')
    const navRubrique: any = document.querySelector('.nav-rubrique')
    icon.addEventListener('click', () => {
      navRubrique.classList.toggle('d-none')
      icon.classList.toggle('fa-ellipsis-vertical')
      icon.classList.toggle('fa-xmark')
    })
  }

  ngAfterViewInit() {

    this.elementRef.nativeElement.addEventListener('click', (e: Event) => this.closeVerticale(e))
    this.elementRef.nativeElement.querySelector('.forumHeaderIcon').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.valider-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.annuler-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-overlay').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-container').addEventListener('click', this.onClick.bind(this));

  }


  openVerticale(e: Event, id: number) {

    console.log(id);


    this.closeVerticale(e)

    e.stopPropagation()
    this.selectedId = id
    const navTopics: any = document.querySelectorAll("#top");
    const icon: any = document.querySelectorAll("#icon");
    const xicon: any = document.querySelectorAll("#Xicon");

    xicon[id].classList.remove('d-none')
    navTopics[id].classList.toggle('d-none')
    icon[id].classList.toggle('fa-ellipsis-vertical')
    icon[id].classList.toggle('d-none')

  }

  /**
   *
   * @param e event
   * @param id
   */
  closeVerticale(e: Event) {
    e.stopPropagation()

    const navTopics: any = document.querySelectorAll("#top");
    const icons: any = document.querySelectorAll("#icon");
    const xicons: any = document.querySelectorAll("#Xicon");


    for (let index = 0; index < navTopics.length; index++) {
      const navTopic = navTopics[index];
      const icon = icons[index];
      const xicon = xicons[index];

      navTopic.classList.add('d-none')
      icon.classList.add('fa-ellipsis-vertical')
      icon.classList.remove('d-none')
      xicon.classList.add('d-none')
    }
  }

  onClick() {
    this.addClass = !this.addClass;
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
      this.topic.rubrique = this.rubrique
      // user
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

  updateTopic(topic: Topic) {
    this.topicService.updateOne(topic).subscribe(() => {
      this.ngOnInit()
    })
  }

}
