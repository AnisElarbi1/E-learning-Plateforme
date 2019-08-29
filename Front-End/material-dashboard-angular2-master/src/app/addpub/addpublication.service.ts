import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { Http, Headers, Response } from '@angular/http';

@Injectable({
  providedIn: 'root'
})
export class Addpublication {
  
 
  host2: string="http://localhost:8081";
  constructor(private http: HttpClient) { }
 addpub(data){
    
        return this.http.post(this.host2+"/publication/ajout",data,{observe: 'response'})
    
 }
 pushFileToStorage(file: File) {
    let formdata: FormData = new FormData();
 
    formdata.append('file', file);
 
    /*const req = new HttpRequest('POST', '/post', formdata, {
      reportProgress: true,
      responseType: 'text'
    });
    this.http.post(this.host+"/post",formdata,{
      reportProgress: true,
      responseType: 'text'
    });
    return this.http.request(req);*/
    return this.http.post(this.host2+"/post",formdata,{reportProgress: true,responseType: 'text'});
  }
 
 

 
}
