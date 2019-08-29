import { Injectable } from '@angular/core' ;
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({


    providedIn:'root'

})
export class UserService{
    public host:string="http://localhost:8081";
    constructor(private http:HttpClient) {}

    getAll():Observable<any> {
        const headers = {
            "authorization": "Bearer " + localStorage.getItem('token')
        }
        console.log(localStorage.getItem('token'))
        return this.http.get("//localhost:8081/user",{headers: headers});
    }
    getAllUser(){
        return this.http.get(this.host+"/user");
    }
    
}
