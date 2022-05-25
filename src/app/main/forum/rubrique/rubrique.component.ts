import { Component, OnInit ,ElementRef ,AfterViewInit} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-rubrique',
  templateUrl: './rubrique.component.html',
  styleUrls: ['./rubrique.component.scss']
})
export class RubriqueComponent implements OnInit {

  selectedId:any;

  rubriques =[
    {id:1,nom:"test1",topicnumber:15},
    {id:2,nom:"test2",topicnumber:15},
    {id:3,nom:"test3",topicnumber:15},
    {id:4,nom:"test4",topicnumber:15},
    {id:5,nom:"test5",topicnumber:15},
  ]

  addClass: boolean = false

  form = new FormGroup({
    name: new FormControl('',Validators.minLength(2))
  });

  constructor(private elementRef: ElementRef) { }

  ngOnInit(): void {   
    };



  ngAfterViewInit() {
    this.elementRef.nativeElement.querySelector('.forumHeaderIcon').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.valider-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.annuler-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-overlay').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-container').addEventListener('click', this.onClick.bind(this));
    
  }

  openVerticale(id:number){
    if (!this.selectedId) {
      this.selectedId = id
    }
    this.closeVerticale(this.selectedId)
    this.selectedId = id
    const navRubrique: any = document.querySelector("#rub"+id);
    const icon: any = document.querySelector("#icon"+id);
    const xicon: any = document.querySelector("#Xicon"+id);
    navRubrique.classList.remove('d-none')
    icon.classList.add('fa-ellipsis-vertical')
    icon.classList.add('d-none')
    xicon.classList.remove('d-none')
    
  }

  closeVerticale(id:number){
    const navRubrique: any = document.querySelector("#rub"+id);
    const icon: any = document.querySelector("#icon"+id);
    const xicon: any = document.querySelector("#Xicon"+id);
    navRubrique.classList.add('d-none')
    icon.classList.add('fa-ellipsis-vertical')
    icon.classList.remove('d-none')
    xicon.classList.add('d-none')
  }

  onClick() {
    
    if (this.selectedId) {
      
    }
    this.addClass = !this.addClass;
  }


}
