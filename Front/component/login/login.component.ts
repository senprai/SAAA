import { Component, OnInit } from '@angular/core';
import { MemberControllerService } from 'src/app/service/controller/member.controller/member-controller.service';
import { Authentication } from 'src/app/service/authentication/authentication';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public static userName:string;

  usernameLogin:string;
  passwordLogin:string;

  constructor(private memberController:MemberControllerService,
              private router:Router) {

               
               }

  ngOnInit() {
  }

  login(){
    if(this.usernameLogin == null || typeof this.usernameLogin === 'undefined'|| this.passwordLogin == null || typeof this.passwordLogin ==='undefined'){
      alert("Please fill Username and Password");

    }else{
      this.memberController.getMemberByUsername(this.usernameLogin).subscribe(data=>{
        if(this.passwordLogin == data.memPass){
          LoginComponent.userName = data.memUser;
          this.router.navigate(['user-profile']);
        }
      },error=>{
          alert("Username invalid");
      })

    }
   

  }

}
