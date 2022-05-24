import { AfterViewChecked, AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import {DataTable} from "simple-datatables"

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit, AfterViewInit {

  dummy ={
    users :[
      {nom:"lancelot",role:0},
      {nom:"arthur",role:1},
      {nom:"merlin",role:0},
      {nom:"perseval",role:0},
      {nom:"genievre",role:1},
      {nom:"galadrielle",role:0},
      {nom:"kev",role:0},
      {nom:"tom",role:1},
      {nom:"momo",role:0},
      {nom:"gigi",role:0},
      {nom:"titi",role:1},
      {nom:"toto",role:0}
    ],
    rubrique :[
      {nom:"general"},
      {nom:"la santé publique"},
      {nom:"biodiversité"},
      {nom:"ecologie"},
      {nom:"rechauffement"},
      {nom:"protaction"},
      {nom:"gaming"},
      {nom:"avent"}
    ]
  }

  constructor(
    private elRef: ElementRef
  ) { }
  
  ngOnInit(): void {

  }
  
  ngAfterViewInit() {
    const datatable = new DataTable("#table", {
      searchable: true,
      fixedHeight: false,
      labels: {
        placeholder: 'Recherchez',
        perPage: "{select} données par page",
        noRows: "Aucune donnée",
        info: "De {start} à {end} sur {rows} données",
      },
       sortable: false
    })
    const style = new Style(this.elRef)
    style.dataTableTopAndBottom('.dataTable-top')
    style.dataTableTopAndBottom('.dataTable-bottom')
    style.pagination()
    style.input()
    datatable.on('datatable.search', () => {
      style.pagination()
    })
  }

}

class Style {
  constructor(
    private elRef: ElementRef
  ){}

  dataTableTopAndBottom(classe: string) {
    const test = this.elRef.nativeElement.querySelector(classe) as HTMLElement
    test.style.display = 'flex'
    test.style.justifyContent = 'space-between'
    test.style.margin = '5px 0'
  }

  pagination() {
    const test = this.elRef.nativeElement.querySelector('.dataTable-pagination-list') as HTMLElement
    const list = this.elRef.nativeElement.querySelectorAll('li')
    const link = this.elRef.nativeElement.querySelectorAll('a')
    test.style.display = 'flex'
    test.style.margin = '0'
    test.style.padding = '0'
    test.style.listStyle = 'none'
    for (const key in list) {
      if (Object.prototype.hasOwnProperty.call(list, key)) {
        list[key].style.margin = '0 5px'  
      }
    }
    for (const key in link) {
      if (Object.prototype.hasOwnProperty.call(link, key)) {
        link[key].style.textDecoration = 'none'
        link[key].style.color = '#2D1E2F'      
      }
    }    
  }

  input() {
    const test = this.elRef.nativeElement.querySelector('.dataTable-input') as HTMLElement
    const select = this.elRef.nativeElement.querySelector('.dataTable-selector') as HTMLElement
    test.style.borderRadius = '5px'
    test.style.border = 'none'
    test.style.boxShadow = '0px 0px 10px rgba(0, 0, 0, 0.25)'
    test.style.padding = '0 5px'
    test.style.height = '20px'
    select.style.padding = '0 0 0 5px'
    select.style.borderRadius = '5px'
  }
}