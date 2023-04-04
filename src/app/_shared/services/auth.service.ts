import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AccountDto} from "../dto/account-dto";

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  url_auth_api: string = "https://localhost:8080/"

  constructor(private http: HttpClient) { }

  createAccount(dtoAccount: AccountDto){
    this.http.post(this.url_auth_api+"signup" , dtoAccount).subscribe();
  }
}
