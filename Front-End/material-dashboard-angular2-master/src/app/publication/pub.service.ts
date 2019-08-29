import { Injectable } from '@angular/core' ;
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({


    providedIn:'root'

})
export class PubService{
    public host:string="http://localhost:8081";
    constructor(private http:HttpClient) {}

  
    getPub(){
        return this.http.get(this.host+"/publications");

    }
  
}










