import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  constructor() { }

  form = {
    mail: '',
    password: '',
    adresse: '',
    cp: '',
    ville: '',
    name: '',
    firstname: ''
  }

  ngOnInit(): void {
  }

  onSubmit(): void {

  }

}
