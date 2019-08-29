import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Http, Headers, Response } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class AuthentificationService {
  
  jwt: string;
  username:string;
  password : string; 
  roles: Array<string>;
  host2: string="http://localhost:8081";
  constructor(private http: HttpClient) { }
  login(data){
    return this.http.post(this.host2+"/login",data,{observe: 'response'})
  }
  
  saveToken(jwt: string,username: string) {
    localStorage.setItem('token',jwt);
    localStorage.setItem('username',username);
    this.username=username;
    this.jwt=jwt;
    this.parseJWT();
  }
  parseJWT(){
    try{
    let jwtHelper= new JwtHelperService();
    let objJWT=jwtHelper.decodeToken(this.jwt);
    this.username=objJWT.obj;
    this.roles=objJWT.roles;
    this.password=objJWT.password;
    localStorage.setItem('role',this.roles[0])
    console.log(this.roles);
    console.log(this.username);
    }catch{}
  }

  isAdmin(){
    return this.roles.indexOf('ADMIN')>=0;
  }
  isUser(){
    return this.roles.indexOf('USER')>=0;
  }
  isEns(){
    return this.roles.indexOf('ENSEIGNANT')>=0;
  }
  isAuthenticated(){
    return this.roles && (this.isAdmin() || this.isUser());
  }
  loadTokent(){
    try{
    this.jwt=localStorage.getItem('token');
    this.parseJWT();}catch{}
  }
  getRole(){
    return this.roles[0];
  }
  logout(){
    localStorage.removeItem('token');
    this.initParams();
  }
  initParams(){
    this.jwt=undefined;
    this.username=undefined;
    this.roles=undefined;
  }
}
