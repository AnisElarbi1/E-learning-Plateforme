import { HttpEventType } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { UploadFileService } from 'app/uploadtest/UploadFileService';
import 'rxjs';
import "rxjs/add/operator/map";
import { HttpResponse } from 'selenium-webdriver/http';
import { UserService } from './inscription.service';

@Component({
  selector: 'app-inscription',
  templateUrl: './inscription.component.html',
  styleUrls: ['./inscription.component.scss']
})
export class InscriptionComponent implements OnInit {
  
  selectedFiles: FileList;
  currentFileUpload: File;
  //progress: { percentage: number } = { percentage: 0 };
  constructor(private userService:UserService, private uploadService:UploadFileService) { }

  ngOnInit() {
    //console.log(img);
  }
  onFileSelected(event){
    const file = event.target.files.item(0);
 
    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
      console.log( this.selectedFiles.item(0).name );
    } else {
      alert('invalid format!');
    }
  }
 
  addUser(data){
    let active=true;
    let img=this.selectedFiles.item(0).name;
    console.log('-----------------------------------------');
    console.log(this.selectedFiles.item(0).name);
    data.actived=active;
    data.img="C:/Users/lenovo/Desktop/Pfa6/Pfa/upload-dir/"+img;
    this.userService.addUser(data).subscribe(resp=>{
      console.log("User ajouter");
      alert("Inscription Ok !!")
      
      },err=>{
        console.log("erreur d'inscription");
      })
      console.log(data);

      this.currentFileUpload = this.selectedFiles.item(0);
      
    this.uploadService.pushFileToStorage(this.currentFileUpload).subscribe(event => {
    
        console.log('File is completely uploaded!');
      
    });
 
    
  }
  }
  

