import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {UploadFileService} from './UploadFileService';
@Component({
  selector: 'app-uploadtest',
  templateUrl: './uploadtest.component.html',
  styleUrls: ['./uploadtest.component.scss']
})
export class UploadtestComponent implements OnInit {
  showFile = false
  fileUploads: Observable<string[]>
  constructor(private uploadService: UploadFileService) { }

  ngOnInit() {
  }
  /*showFiles(enable: boolean) {
    this.showFile = enable
 
    if (enable) {
      this.fileUploads = this.uploadService.getFiles();
    }
  }*/
}
