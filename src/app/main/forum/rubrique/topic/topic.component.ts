import { Component, ElementRef, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {
  addclass: boolean = false


  topics =[
    {id:1,nom:"topic 1",replays:1 , startedby:"waseem" , lastReplayUser:"thomas" , lastReplayDate:"28/05/2022"},
    {id:2,nom:"topic 2",replays:2 , startedby:"thomas" , lastReplayUser:"waseem" , lastReplayDate:"27/05/2022"},
    {id:3,nom:"topic 3",replays:10 , startedby:"Guillaume" , lastReplayUser:"Thibault" , lastReplayDate:"27/05/2022"},
    {id:4,nom:"topic 4",replays:5 , startedby:"Thibault" , lastReplayUser:"Guillaume" , lastReplayDate:"26/05/2022"},
    {id:5,nom:"topic 5",replays:8 , startedby:"Guillaume" , lastReplayUser:"thomas" , lastReplayDate:"25/05/2022"},
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
  
}
