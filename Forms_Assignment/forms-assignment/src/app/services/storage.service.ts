import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class StorageService {
  public users : any[] = [];
  showLogin : boolean = true;

  constructor() { 
    console.log("Storage service object is created....");
  }

  public toggleComponent(){
    this.showLogin = !this.showLogin;
  }

  chatMessage(user:string){
    this.users.push(user);
  }
}
