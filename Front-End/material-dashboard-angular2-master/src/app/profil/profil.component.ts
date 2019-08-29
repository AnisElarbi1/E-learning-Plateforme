import { Component, OnInit } from '@angular/core';
import  "rxjs/add/operator/map";
import  'rxjs';
import { UserService } from './UserService';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.scss']
})
export class ProfilComponent implements OnInit {
  
   users;
   img;
  constructor(private userService:UserService) { }

  ngOnInit() {
    this.userService.getAllUser().subscribe(data =>{
      this.users=data ;
    })
    
  }

}
