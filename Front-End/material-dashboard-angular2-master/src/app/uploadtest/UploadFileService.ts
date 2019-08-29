import {Injectable} from '@angular/core';
import {HttpClient, HttpRequest, HttpEvent} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
 
@Injectable()
export class UploadFileService {
  public host:string="http://localhost:8081";
  constructor(private http: HttpClient) {}
 
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
    return this.http.post(this.host+"/post",formdata,{reportProgress: true,responseType: 'text'});
  }
 
 /* getFiles() {
    return this.http.get('/files/{filename:.+}');
  }*/

  
}