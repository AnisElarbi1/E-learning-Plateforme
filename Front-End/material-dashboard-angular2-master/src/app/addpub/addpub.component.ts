import { Component, OnInit } from '@angular/core';
import { Addpublication } from './addpublication.service';
import { DatePipe } from '@angular/common';
import { Publication } from './publication';
import * as $ from 'jquery';
@Component({
  selector: 'app-addpub',
  templateUrl: './addpub.component.html',
  styleUrls: ['./addpub.component.scss'],
  providers: [DatePipe]
})

export class AddpubComponent implements OnInit {
  selectedFiles: FileList;
  currentFileUpload: File;
  myDate = new Date();
  datee:string;
  publication: Publication []=[];

  constructor(private addpublicationservice:Addpublication, private datePipe: DatePipe) {
    this.datee = this.datePipe.transform(this.myDate, 'yyyy-MM-dd');
    console.log(this.datee);
   }
 ens_id=localStorage.getItem('id');
  matiere_id=1;
  ngOnInit() {
    $(function() {
      $('#typeselector').change(function(){
        $('#Fichier').hide();
        $('#' + $(this).val()).show();
      });
    });
  }
addpublication(data){
   
  if(data.type=="Video"){
    let name=data.contenu.substr(32);
    data.contenu=name;
    data.date=this.datee;
  return this.addpublicationservice.addpub(data).subscribe(resp=>{
    },err=>{
      console.log("erreur de la l'ajout");
      alert("Erreur lors de l'ajout de la publication ")
    })}else if(data.type=="Fichier"){
      let name=this.selectedFiles.item(0).name;
      data.contenu=name;
      data.date=this.datee;
      this.addpublicationservice.addpub(data).subscribe(resp=>{
      },err=>{
        console.log("erreur de la l'ajout");
        alert("Erreur lors de l'ajout de la publication ")
      });
      
      this.currentFileUpload = this.selectedFiles.item(0);
      
    this.addpublicationservice.pushFileToStorage(this.currentFileUpload).subscribe(event => {
    
        console.log('File is completely uploaded!');
      
    });
    }else if(data.type=="Statut"){
      data.date=this.datee;
      return this.addpublicationservice.addpub(data).subscribe(resp=>{
      },err=>{
        console.log("erreur de la l'ajout");
        alert("Erreur lors de l'ajout de la publication ")
      })
    }else{alert("il faut choisir le type de la publication")}
}
onFileSelected(event){
  const file = event.target.files.item(0);

  if (file.type.match('\.pdf')) {
    this.selectedFiles = event.target.files;
    console.log( this.selectedFiles.item(0).name );
  } else {
    alert('invalid format!');
  }
}

}
