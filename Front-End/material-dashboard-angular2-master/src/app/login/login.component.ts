import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from './authentification.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private authService: AuthentificationService) { }

  ngOnInit() {
  }
  onLogin(data){
    this.authService.login(data).subscribe(resp=>{
    console.log(resp.headers.get('Authorization'));
    let jwt= resp.headers.get('Authorization');
    let username=data.username;
    this.authService.saveToken(jwt,username);
    },err=>{
      console.log("verifier login ou mdp");
    })
    console.log(data);
  } 

  isAdmin(){
    return this.authService.isAdmin();
  }
  isUser(){
    return this.authService.isUser();
  }
  isEns(){
    return this.authService.isEns();
  }
}
