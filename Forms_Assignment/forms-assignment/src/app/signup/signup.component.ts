import { Component } from '@angular/core';
import { StorageService } from '../services/storage.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup',
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  constructor(public st : StorageService){}

  Registerform:any;

  ngOnInit(){
    this.Registerform = new FormGroup({
        customerId : new FormControl('', [
          Validators.required, 
          Validators.pattern('^[0-9]{7}$') 
        ]),
        username : new FormControl('', [
          Validators.required,
          Validators.minLength(5), 
          Validators.pattern('^[A-Za-z]{5,}$') 
        ]),
        password : new FormControl('', [
          Validators.required,
          Validators.minLength(8)
        ]),
        confirmPassword : new FormControl('', [Validators.required]),
        accountNumber : new FormControl('', [
          Validators.required, 
          Validators.minLength(6) 
        ])
      } );
      this.Registerform.setValidators(this.passwordMatchValidator); 
    }

  passwordMatchValidator(group: FormGroup): { [key: string]: boolean } | null {
    const password = group.get('password')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    if (password !== confirmPassword) {
      return { mismatch: true }; 
    }
    return null; 
  }

  handleSubmit(obj:any):void{
    console.log(obj);
    this.st.users.push(obj);
  }
}
