// utilisé la logique du ngoninit pour rappel une fonction qui vue off
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
    {id:0,nom:"test1",topicnumber:15},
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
    this.elementRef.nativeElement.addEventListener('click',(e:Event)=>this.closeVerticale(e))
    this.elementRef.nativeElement.querySelector('.forumHeaderIcon').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.valider-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.annuler-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-overlay').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-container').addEventListener('click', this.onClick.bind(this));
  }

  openVerticale(e:Event,id:number){
    this.closeVerticale(e)
    
    e.stopPropagation()

    console.log(id);
    

    this.selectedId = id
    const navRubrique: any = document.querySelectorAll("#rub");
    const icon: any = document.querySelectorAll("#icon");
    const xicon: any = document.querySelectorAll("#Xicon");
    
    xicon[id].classList.remove('d-none')
    navRubrique[id].classList.toggle('d-none')
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
    
    const navRubriques: any = document.querySelectorAll("#rub");
    const icons: any = document.querySelectorAll("#icon");
    const xicons: any = document.querySelectorAll("#Xicon");

    
    for (let index = 0; index < navRubriques.length; index++) {
      const navRubrique = navRubriques[index];
      const icon = icons[index];
      const xicon = xicons[index];
      
      navRubrique.classList.add('d-none')
      icon.classList.add('fa-ellipsis-vertical')
      icon.classList.remove('d-none')
      xicon.classList.add('d-none')
    }
  }

  onClick() {
    this.addClass = !this.addClass;
  }


}
