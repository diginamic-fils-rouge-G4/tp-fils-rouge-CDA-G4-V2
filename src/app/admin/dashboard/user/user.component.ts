import { Component, OnInit } from '@angular/core';
import {DataTable} from "simple-datatables"

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {

  dummy ={
    users :[
      {nom:"lancelot",role:"0"},
      {nom:"arthur",role:"1"},
      {nom:"merlin",role:"0"},
      {nom:"perseval",role:"0"},
      {nom:"genievre",role:"1"},
      {nom:"galadrielle",role:"0"},
      {nom:"kev",role:"0"},
      {nom:"tom",role:"1"},
      {nom:"momo",role:"0"},
      {nom:"gigi",role:"0"},
      {nom:"titi",role:"1"},
      {nom:"toto",role:"0"}
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

  
  constructor() { }
  
  ngOnInit(): void {

  }
  
  ngAfterViewInit() {
    new DataTable("#table", {
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
    
  }

}
