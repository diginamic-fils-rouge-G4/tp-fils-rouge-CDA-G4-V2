import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class JwtTokenService {

  constructor() { }

  saveTokenAdmin(token:string): void {
    localStorage.setItem('admin-token', token)
  }

  saveTokenUser(token:string): void {
    localStorage.setItem('user-token', token)
  }

}
