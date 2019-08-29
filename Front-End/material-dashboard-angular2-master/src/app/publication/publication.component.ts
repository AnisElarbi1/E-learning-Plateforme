import { Component, OnInit } from '@angular/core';
import { PubService } from './pub.service';


@Component({
  selector: 'app-publication',
  templateUrl: './publication.component.html',
  styleUrls: ['./publication.component.scss']
})
export class PublicationComponent implements OnInit {
  player: YT.Player;
  pubs;

  link: string;
  constructor(private pubService: PubService) { }

  ngOnInit() {
    this.pubService.getPub().subscribe(data =>{
      this.pubs=data;
      })
  }
  checkIfVid( type: string ): boolean {
    
  if ( type=="Video") {
    return true;
}
return false;
}
checkIfFile( type: string ): boolean {
  
  if ( type=="Fichier") {
      return true;
  }
  return false;
}
checkIfStatut( type: string ): boolean {
  
  if ( type=="Statut") {
      return true;
  }
  return false;
}
  getId(id: string): string{
    console.log(id)
    return id;
  }
  savePlayer(player) {
    this.player = player;
    console.log('player instance', player);
  }
  onStateChange(event) {
    console.log('player state', event.data);
  }

}
