import { Component, OnInit } from '@angular/core';
import { MainServiceService } from '../main-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(private _service:MainServiceService, private router:Router) { }
   b:boolean;
   message:string;

  ngOnInit() {
  }


  loginUser(event)
  {
event.preventDefault();
console.log(event);

var username=event.target.elements[0].value;
var password=event.target.elements[1].value;

this._service.verifyUser(username,password)
.subscribe((userData) =>{
  this.b=userData;

  if(this.b=true)
  {
    this.router.navigate(['view']);
  }
  else{
    this.message="sorry username or password is invalid"

  }

}, (error) =>{
  console.log(error);
  
});
 }


}
