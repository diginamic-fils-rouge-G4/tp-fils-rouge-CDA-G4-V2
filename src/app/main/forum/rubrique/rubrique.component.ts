import { Component, OnInit ,ElementRef ,AfterViewInit} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-rubrique',
  templateUrl: './rubrique.component.html',
  styleUrls: ['./rubrique.component.scss']
})
export class RubriqueComponent implements OnInit {

  addclass: boolean = false

  form = new FormGroup({
    name: new FormControl(Validators.minLength(2))
  });

  constructor(private elementRef: ElementRef) { }

  ngOnInit(): void {
    const icon: any = document.querySelector('.ellipse')
    const navRubrique: any = document.querySelector('.nav-rubrique')
    icon.addEventListener('click',() => {
      navRubrique.classList.toggle('d-none')
      icon.classList.toggle('fa-ellipsis-vertical')
      icon.classList.toggle('fa-xmark')
    })}

  ngAfterViewInit() {
    this.elementRef.nativeElement.querySelector('.forumHeaderIcon').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.valider-btn').addEventListener('click', this.onClick.bind(this));
    this.elementRef.nativeElement.querySelector('.modal-overlay').addEventListener('click', this.onClick.bind(this));
  }

  onClick() {
    if (this.addclass == false) {
      this.addclass = true
    }
    else{
      this.addclass = false
    }
  }


}
