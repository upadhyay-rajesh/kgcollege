import { Component, OnInit } from '@angular/core';
import { FacebookUser } from './entity/facebook';
import { FacebookService } from './facebook.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
	//passing private object inside constructor is known as dependency injenction
	constructor(private ss:FacebookService){}

  mydata:any=[];

  ngOnInit(): void {
    
    this.ss.viewAllUser()
      .subscribe( data => {
        console.log(data);
        this.mydata = data;
      });
  }

	deleteRecord(email:string):void{
    this.ss.deleteUser(email).subscribe(data=>{
      console.log("record deleted");
    })
  }
	password:string="Hello";
	
	//string a="hi";
	
	a:string="hi";
	
  title = 'firstangular';
  user1: FacebookUser=new FacebookUser() ;
  
  registerUser(email:string,name:string,password:string,address:string): void {
    console.log(email);
   this.user1= new FacebookUser(email,name,password,address);
   //now passing object of entity to service
    this.ss.registerService(this.user1)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };
}










