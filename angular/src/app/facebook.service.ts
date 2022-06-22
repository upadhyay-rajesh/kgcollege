import { Injectable } from '@angular/core';
import { FacebookUser } from './entity/facebook';
import {HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class FacebookService {

  constructor(private http:HttpClient) { }
  
  viewAllUser(){
    return  this.http.get("http://localhost:10000/viewAllProfile");
    
  }

  public deleteUser(email:any) {
    return this.http.delete("http://localhost:10000/deleteProfile" + "/"+email);
  }

  public  registerService(a:FacebookUser) {
   
    return this.http.post<FacebookUser>("http://localhost:10000/createProfile", a);
  }
}










