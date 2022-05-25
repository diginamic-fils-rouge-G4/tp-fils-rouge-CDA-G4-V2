import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  formSubmitted: boolean = false
  formLogin = new FormGroup({
    mail: new FormControl('',
      [
        Validators.required, 
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
      ]
    ),
    password: new FormControl('',
      [
        Validators.required,
        Validators.minLength(12)
      ]
    )
  });

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

  onSubmitLogin(): void {
    this.formSubmitted = true
    console.log(this.formLogin.controls['password'])
  }

  onSubmitSignup(): void {

  }

}
