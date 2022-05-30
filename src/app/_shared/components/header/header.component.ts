import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit ,AfterViewInit{

  loginVisible:boolean =false;
  SignupVisible:boolean =false;

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

  constructor(private elementRef: ElementRef) { }

  ngOnInit(): void {
  }

  ngAfterViewInit(){

    this.elementRef.nativeElement.querySelector('.Connexion').addEventListener('click', this.onClickLogin.bind(this));

    this.elementRef.nativeElement.querySelector('.Inscription').addEventListener('click', this.onClickSignup.bind(this));

    this.elementRef.nativeElement.querySelector('#closeCon').addEventListener('click', this.onClickLogin.bind(this),);

    this.elementRef.nativeElement.querySelector('#closeIns').addEventListener('click', this.onClickSignup.bind(this));

    // reset les forms avec le X
    // this.elementRef.nativeElement.querySelector('#closeCon').addEventListener('click', this.resetForm.bind(this),);

    // this.elementRef.nativeElement.querySelector('#closeIns').addEventListener('click', this.resetForm.bind(this));
    //

    this.elementRef.nativeElement.querySelector('#containerCon').addEventListener('click', this.onClickLogin.bind(this));

    this.elementRef.nativeElement.querySelector('#wrapperCon').addEventListener('click', this.onClickLogin.bind(this));

    this.elementRef.nativeElement.querySelector('#containerIns').addEventListener('click', this.onClickSignup.bind(this));

    this.elementRef.nativeElement.querySelector('#wrapperIns').addEventListener('click', this.onClickSignup.bind(this));

  }

  onSubmitLogin(): void {
    this.formSubmittedLogin = true
    this.formSubmittedSignup = false
    console.log(this.formLogin)
  }

  onSubmitSignup(): void {
    this.formSubmittedSignup = true
    this.formSubmittedLogin = false
    console.log(this.formsignup)
    this.passwordConfirmValid()

  }

  // function pour reset les valeurs et errors des forms
  // resetForm(){
  //   this.formsignup.reset()
  //   this.formLogin.reset()
  //   this.formSubmittedLogin = false
  //   this.formSubmittedSignup = false
  // }


  passwordConfirmValid(): any {
    return this.formsignup.controls['password'].value === this.formsignup.controls['confirmPassword'].value
      ? null : {'mismatch': true};
  }


  onClickLogin() {
    this.loginVisible = !this.loginVisible;
  }

  onClickSignup() {
    this.SignupVisible = !this.SignupVisible;
  }

}
