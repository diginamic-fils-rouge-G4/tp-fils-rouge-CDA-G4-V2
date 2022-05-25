import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {

  formSubmittedLogin: boolean = false
  formSubmittedSignup: boolean = false
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

  formsignup = new FormGroup({
    name: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(2)
      ]
    ),
    firstname: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(2)
      ]
    ),
    mail: new FormControl('',
      [
        Validators.required, 
        Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
      ]
    ),
    city: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(3)
      ]
    ),
    cp: new FormControl('', 
      [
        Validators.required,
        Validators.minLength(5),
        Validators.maxLength(5),
        Validators.pattern("^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{12,}$")
      ]
    ),
    password: new FormControl('',
      [
        Validators.required,
        Validators.minLength(12)
      ]
    ),
    confirmPassword: new FormControl('',
      [
        Validators.required,
        Validators.minLength(12)
      ]
    )
  })

  constructor() { }

  ngOnInit(): void {
  }

  onSubmitLogin(): void {
    this.formSubmittedLogin = true
    console.log(this.formLogin)
  }

  onSubmitSignup(): void {
    this.formSubmittedSignup = true
    console.log(this.formsignup)
    this.passwordConfirmValid()

  }

  passwordConfirmValid(): any {
    return this.formsignup.controls['password'].value === this.formsignup.controls['confirmPassword'].value
      ? null : {'mismatch': true};
  }

}
