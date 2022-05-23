import { Component, ElementRef, OnInit } from '@angular/core';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.scss']
})
export class TopicComponent implements OnInit {

  addclass: boolean = false

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
