import { Component, OnInit} from '@angular/core';
import { AuthentificationService } from './login/authentification.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  
constructor(private authService: AuthentificationService){}
ngOnInit(): void {
  this.authService.loadTokent();
}
isAdmin(){
  return this.authService.isAdmin();
}
isUser(){
  return this.authService.isUser();
}


isAthenticated(){
  return this.authService.isAuthenticated();
}

}



