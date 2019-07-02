import { Component, OnInit } from '@angular/core';
import { SharedService } from '../service/shared.service';
import { UserService } from '../service/user/user.service';
import { Router } from '@angular/router';
import { User } from '../model/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  brand: string = "<Hucs/>";
  public shared: SharedService;

  constructor(private userService: UserService,
              private router: Router){
      this.shared = SharedService.getInstance();
      this.shared.user = new User('','','','');
  }

  ngOnInit(){
  }

  signOut() : void {
    console.log(this.shared.token);
    this.shared.token = null;
    this.shared.user = null;
    window.location.href = '/login';
    window.location.reload();
  }

}