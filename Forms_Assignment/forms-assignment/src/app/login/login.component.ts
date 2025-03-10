import { Component } from '@angular/core';
import { StorageService } from '../services/storage.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [CommonModule ,FormsModule, ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  LoginForm:any;
  
  ngOnInit(){
    this.LoginForm = new FormGroup({
      customerId: new FormControl("Guest"),
      password: new FormControl("", Validators.compose([
        Validators.required
      ])),
    })
  }

  submitForm(formValues: any): void {
    if (this.LoginForm.valid) {
      console.log('Form submitted with:', formValues);
    } else {
      console.log('Form is invalid');
    }
  }

  constructor(public st : StorageService){}

}
