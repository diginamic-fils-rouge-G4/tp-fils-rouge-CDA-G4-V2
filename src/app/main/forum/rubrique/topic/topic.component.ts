import { Component, ElementRef, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {
  addClass: boolean = false
  selectedId:any;
  
  topics =[
    {id:0,nom:"topic 1",replays:1 , startedby:"waseem" , lastReplayUser:"thomas" , lastReplayDate:"28/05/2022"},
    {id:1,nom:"topic 2",replays:2 , startedby:"thomas" , lastReplayUser:"waseem" , lastReplayDate:"27/05/2022"},
    {id:2,nom:"topic 3",replays:10 , startedby:"Guillaume" , lastReplayUser:"Thibault" , lastReplayDate:"27/05/2022"},
    {id:3,nom:"topic 4",replays:5 , startedby:"Thibault" , lastReplayUser:"Guillaume" , lastReplayDate:"26/05/2022"},
    {id:4,nom:"topic 5",replays:8 , startedby:"Guillaume" , lastReplayUser:"thomas" , lastReplayDate:"25/05/2022"},
  ]

  form = new FormGroup({
    name: new FormControl('',Validators.minLength(2))
  });

  constructor(private elementRef:ElementRef) { }

  ngOnInit(): void {

    const icon: any = document.querySelector('.ellipse')
    const navRubrique: any = document.querySelector('.nav-rubrique')
    icon.addEventListener('click',() => {
      navRubrique.classList.toggle('d-none')
      icon.classList.toggle('fa-ellipsis-vertical')
      icon.classList.toggle('fa-xmark')
    })
  }

  ngAfterViewInit() {

    this.elementRef.nativeElement.addEventListener('click',(e:Event)=>this.closeVerticale(e))
    this.elementRef.nativeElement.querySelector('.forumHeaderIcon').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.valider-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.annuler-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-overlay').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-container').addEventListener('click', this.onClick.bind(this));

  }


  openVerticale(e:Event,id:number){

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
  closeVerticale(e:Event){
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


  
}
