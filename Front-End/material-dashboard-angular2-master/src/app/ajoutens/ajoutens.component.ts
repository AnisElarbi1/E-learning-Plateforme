import { Component, OnInit } from '@angular/core';
import { AjoutEns } from './ajoutens.service';

@Component({
  selector: 'app-ajoutens',
  templateUrl: './ajoutens.component.html',
  styleUrls: ['./ajoutens.component.scss']
})
export class AjoutensComponent implements OnInit {
matieres={};
  constructor(private ajoutEns: AjoutEns) { }

  ngOnInit() {
  this.matieres = this.ajoutEns.getMat().subscribe(data =>{
    this.matieres=data;
   
    }
    
    
   
  )
  
  console.log(this.matieres)
  }
  addEns(data){
    console.log("----------------------------------------------------------------------------------------------------------------------------------------")
    console.log(data.matiere)
    return this.ajoutEns.addEns(data).subscribe(resp=>{
    },err=>{
      console.log("erreur de la l'ajout");
      alert("Erreur lors de l'ajout de l enseignant ")
    })
  }
}
