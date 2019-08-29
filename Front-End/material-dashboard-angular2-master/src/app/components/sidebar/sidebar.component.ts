import { Component, OnInit } from '@angular/core';
import { AuthentificationService } from 'app/login/authentification.service';

declare const $: any;
declare interface RouteInfo {
    path: string;
    title: string;
    icon: string;
    class: string;
    type: string;
}
export const ROUTES: RouteInfo[] = [
    { path: '/dashboard', title: 'Dashboard',  icon: 'dashboard', class: '',type: 'ENSEIGNANT' },
    { path: '/user-profile', title: 'User Profile',  icon:'person', class: '',type: 'USER' },
    { path: '/table-list', title: 'Table List',  icon:'content_paste', class: '',type: 'ADMIN' },
    { path: '/typography', title: 'Typography',  icon:'library_books', class: '',type: 'ENSEIGNANT' },
    { path: '/icons', title: 'Icons',  icon:'bubble_chart', class: '',type: 'USER' },
    { path: '/notifications', title: 'Notifications',  icon:'notifications', class: '',type: 'ADMIN' },
   
];

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {
  menuItems: any[];

  constructor(private authService: AuthentificationService) { }

  ngOnInit() {
   // this.menuItems = ROUTES.filter(menuItem => menuItem);
  }
  isMobileMenu() {
      if ($(window).width() > 991) {
          return false;
      }
      return true;
  }

  isAdmin(){
    return this.authService.isAdmin();
  }
  isUser(){
    return this.authService.isUser();
  }

  isEns(){
    return this.authService.isEns();
  }
  isAuthentified(){
    return this.authService.isAuthenticated();
  }
  getRole(){
    return this.authService.getRole();
  }
  logout(){
    this.authService.logout();
  }
}
