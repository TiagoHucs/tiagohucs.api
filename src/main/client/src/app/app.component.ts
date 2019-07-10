import { Component } from '@angular/core';
import { UserService } from './service/user/user.service';
import { AuthService } from './security/auth.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  showTemplate: boolean = false;
  
  constructor(public authService: AuthService){
  }

  ngOnInit(){
  }

}