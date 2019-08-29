import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class AjoutEns {
  
 
  host2: string="http://localhost:8081";
  constructor(private http: HttpClient) { }
  addEns(data){
    
        return this.http.post(this.host2+"/userens",data,{observe: 'response'})
    
 }
 getMat(){
    return this.http.get(this.host2+"/matieres");

}
 

 
}
