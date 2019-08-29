import { Component, OnInit } from '@angular/core';
import  "rxjs/add/operator/map";
import  'rxjs';
import { UserService } from './user-profil.service';
import { AuthentificationService } from 'app/login/authentification.service';
import { Observable } from 'rxjs';
import { ResourceLoader } from '@angular/compiler';
@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {
 user ;
 imge:String="";
role:String=localStorage.getItem('role');
imgupload: Observable<string[]>;

  constructor(private userService:UserService, private authService: AuthentificationService) { }

  ngOnInit() {
    this.userService.getUser().subscribe(data =>{
      this.user=data;
      localStorage.setItem('id',this.user.id);
      this.imge=""+this.user.img;
      }
      
      
     
    )
    
  //  this.imgupload=this.userService.getImg();
    
  }
  isEns(){
    return this.authService.isEns();
  }

  onUpdate(data){
    this.userService.updateProfil(data).subscribe(resp=>{
      console.log(data.nom);
      
     
      },err=>{
        console.log("erreur de la modification");
      })
      console.log(data);
  }
 

}
