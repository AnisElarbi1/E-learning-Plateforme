import { Injectable } from '@angular/core' ;
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({


    providedIn:'root'

})
export class UserService{
    public host:string="http://localhost:8081"; 
    constructor(private http:HttpClient) {}

  
    

    addUser(data){
        return this.http.post(this.host+"/user/ajout",data,{observe: 'response'})
    }
}










