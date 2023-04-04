import { Injectable } from '@angular/core';
import jwtDecode from "jwt-decode";

@Injectable({
  providedIn: 'root'
})
export class JwtTokenService {

  constructor() { }

  saveToken(token:string): void {
    localStorage.setItem('token', token)
  }

  getToken() {
    return localStorage.getItem('token')
  }

  deleteToken() {
    localStorage.removeItem('token')
  }

  decodeToken(token: string) {
    return jwtDecode(token)
  }

  isAdmin(token: string): boolean {
    if(this.getToken() != null) {
      const userToken: any = this.decodeToken(token)
      if(userToken.roles === "ROLE_ADMIN") {
        return true
      }
    }
    return false
  }

  isUser(token: string): boolean {
    if(this.getToken() != null) {
      const userToken: any = this.decodeToken(token)
      if(userToken.roles === "ROLE_USER") {
        return true
      }
    }
    return false
  }

  isVisitor(): boolean {
    return this.getToken() == null;
  }

  getUserMail(): string {
    const token = this.getToken()
    let userMail: string = ""
    if(token !== null) {
      const userToken: any = this.decodeToken(token)
      userMail = userToken.sub
    }
    return userMail
  }

}
