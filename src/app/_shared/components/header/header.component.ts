import { AfterViewInit, Component, ElementRef, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { AccountDto } from '../../dto/account-dto';
import { LoginDto } from '../../dto/login-dto';

import { JwtTokenService } from '../../services/jwt-token.service';
import { AuthService } from '../../services/auth.service';
import jwtDecode from 'jwt-decode';
import { Router } from '@angular/router';
import { AppError } from '../../interfaces/error';
import { AppErrorImpl } from '../../class/AppErrorImpl';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss'],
})
export class HeaderComponent implements OnInit, AfterViewInit {
  connected!: boolean;

  isAdmin: boolean = false;
  isUser: boolean = false;

  token!: any;
  loginVisible: boolean = false;
  SignupVisible: boolean = false;
  logoutVisible: boolean = false;

  formSubmittedLogin: boolean = false;
  formSubmittedSignup: boolean = false;
  formDtoLogin: LoginDto = {};

  formLogin = new FormGroup({
    mail: new FormControl('', [
      Validators.required,
      Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(12),
    ]),
  });

  formDtoSignup: AccountDto = {};

  formsignup = new FormGroup({
    name: new FormControl('', [Validators.required, Validators.minLength(2)]),
    firstname: new FormControl('', [
      Validators.required,
      Validators.minLength(2),
    ]),
    mail: new FormControl('', [
      Validators.required,
      Validators.pattern('^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$'),
    ]),
    ville: new FormControl('', [Validators.required, Validators.minLength(3)]),
    cp: new FormControl('', [
      Validators.required,
      Validators.minLength(5),
      Validators.maxLength(5),
      Validators.pattern('^\\d{5}$'),
    ]),
    password: new FormControl('', [
      Validators.required,
      Validators.minLength(12),
    ]),
    confirmPassword: new FormControl('', [
      Validators.required,
      Validators.minLength(12),
    ]),
  });
  errorList: AppErrorImpl[] = [];
  url_auth_api: string = 'http://localhost:8080/';

  constructor(
    private elementRef: ElementRef,
    private http: HttpClient,
    private jwtTokenService: JwtTokenService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.connected = this.jwtTokenService.getToken() !== null;
    this.logoutVisible = this.connected;
    const token = this.jwtTokenService.getToken()
    if(token != null) {
      this.isAdmin = this.jwtTokenService.isAdmin(token)
    }
  }

  ngAfterViewInit() {
    this.elementRef.nativeElement
      .querySelector('.Connexion')
      .addEventListener('mousedown', this.onClickLogin.bind(this));
    this.elementRef.nativeElement
      .querySelector('.Inscription')
      .addEventListener('mousedown', this.onClickSignup.bind(this));
    this.elementRef.nativeElement
      .querySelector('#closeCon')
      .addEventListener('mousedown', this.onClickLogin.bind(this));
    this.elementRef.nativeElement
      .querySelector('#closeIns')
      .addEventListener('mousedown', this.onClickSignup.bind(this));

    // reset les forms avec le X
    // this.elementRef.nativeElement.querySelector('#closeCon').addEventListener('click', this.resetForm.bind(this),);

    // this.elementRef.nativeElement.querySelector('#closeIns').addEventListener('click', this.resetForm.bind(this));
    //

    this.elementRef.nativeElement
      .querySelector('#containerCon')
      .addEventListener('mousedown', this.onClickLogin.bind(this));

    this.elementRef.nativeElement
      .querySelector('#wrapperCon')
      .addEventListener('mousedown', this.onClickLogin.bind(this));

    this.elementRef.nativeElement
      .querySelector('#containerIns')
      .addEventListener('mousedown', this.onClickSignup.bind(this));

    this.elementRef.nativeElement
      .querySelector('#wrapperIns')
      .addEventListener('mousedown', this.onClickSignup.bind(this));
  }

  onSubmitLogin(): void {
    this.formSubmittedLogin = true;
    this.formSubmittedSignup = false;

    if (this.formLogin.valid) {
      this.formDtoLogin.password = this.formLogin.value.password;
      this.formDtoLogin.email = this.formLogin.value.mail;
      const authHeaders = {
        headers: new HttpHeaders({
          'Access-Control-Allow-Origin': '*',
          'content-type': 'application/json',
        }),
        observe: 'response' as 'response',
      };

      this.http
        .post(this.url_auth_api + 'login', this.formDtoLogin, authHeaders)
        .subscribe(
          (response: any) => {
            this.jwtTokenService.saveToken(response.body.token);
            this.isAdmin = this.jwtTokenService.isAdmin(response.body.token);
            this.isUser = this.jwtTokenService.isUser(response.body.token);
            this.connected = true;
            this.logoutVisible = this.connected;
          },
          (error: any) => {
            this.errorManager(error);
          }
        );
    }
  }
  errorManager(error: any): void {
    
    console.log(error.status);
    
    switch (error.status) {
      case 401:
        this.errorList.push(AppErrorImpl[401]);
        break;
      case 403:
        this.errorList.push(AppErrorImpl[403]);
        console.log(this.errorList);
        
        break;

      default:
        break;
    }
  }
  onClickLogout(): void {
    this.connected = false;
    this.logoutVisible = this.connected;
    this.isAdmin = false;
    this.isUser = false;
    this.jwtTokenService.deleteToken();
    this.loginVisible = false;
    this.SignupVisible = false;
    this.formLogin.reset();
    this.router.navigate(['accueil']);
  }

  onSubmitSignup(): void {
    this.formSubmittedSignup = true;
    this.formSubmittedLogin = false;
    this.passwordConfirmValid();
    if (this.formsignup.valid) {
      this.formDtoSignup.nom = this.formsignup.value.name;
      this.formDtoSignup.prenom = this.formsignup.value.firstname;
      this.formDtoSignup.ville = this.formsignup.value.ville;
      this.formDtoSignup.mail = this.formsignup.value.mail;
      this.formDtoSignup.password = this.formsignup.value.password;
      this.formDtoSignup.codePostal = this.formsignup.value.cp;
      const authHeaders = {
        headers: new HttpHeaders({
          'Access-Control-Allow-Origin': '*',
          'content-type': 'application/json',
        }),
      };
      this.http
        .post<AccountDto>(
          this.url_auth_api + 'signup',
          this.formDtoSignup,
          authHeaders
        )
        .subscribe(
          () => {
            this.loginVisible = true;
            this.SignupVisible = false;
          },
          (error: any) => {
            console.log(error.status);
            
            this.errorManager(error);
          }
        );
    }
  }

  // function pour reset les valeurs et errors des forms
  // resetForm(){
  //   this.formsignup.reset()
  //   this.formLogin.reset()
  //   this.formSubmittedLogin = false
  //   this.formSubmittedSignup = false
  // }

  passwordConfirmValid(): any {
    return this.formsignup.controls['password'].value ===
      this.formsignup.controls['confirmPassword'].value
      ? null
      : { mismatch: true };
  }

  onClickLogin() {
    this.loginVisible = !this.loginVisible;
  }

  onClickSignup() {
    this.SignupVisible = !this.SignupVisible;
  }
  switchLoginSignup() {
    this.onClickLogin();
    this.onClickSignup();
  }

  findError(statusCode: number){
    return this.errorList.find((appErrorImpl) => {
      return appErrorImpl.statusCode == statusCode;
    });
  }
}
