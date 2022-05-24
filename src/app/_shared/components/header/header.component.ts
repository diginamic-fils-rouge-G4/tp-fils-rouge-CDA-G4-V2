import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  formlogin = {
    mail: '',
    password: ''
  }

  formsignup = {
    mail: '',
    password: '',
    adresse: '',
    cp: '',
    ville: '',
    name: '',
    firstname: ''
  }

  constructor() { }

  ngOnInit(): void {
  }

  onSubmit(): void {

  }

}
