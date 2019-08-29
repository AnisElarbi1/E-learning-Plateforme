import { Injectable } from '@angular/core' ;
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({


    providedIn:'root'

})
export class UserService{
    public host:string="http://localhost:8081";
    constructor(private http:HttpClient) {}

  
    getUser(){
        return this.http.get(this.host+"/profil?username="+localStorage.getItem('username'));

    }
    getAll():Observable<any> {
        return this.http.get("//localhost:8081/profil?username="+localStorage.getItem('username'));
    }

    updateProfil(data){
        return this.http.put(this.host+"/profilupdate/"+localStorage.getItem('username'),data,{observe: 'response'})
    }

    getImg(): Observable<any>{
        return this.http.get(this.host+"/files/abdos.jpg");
    }
}










