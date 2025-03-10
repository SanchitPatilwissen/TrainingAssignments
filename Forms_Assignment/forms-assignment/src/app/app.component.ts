import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { SignupComponent } from './signup/signup.component';
import { LoginComponent } from './login/login.component';
import { CommonModule } from '@angular/common';
import { StorageService } from './services/storage.service';

@Component({
  selector: 'app-root',
  imports: [SignupComponent, LoginComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  constructor(public st : StorageService){}

  showLogin : boolean = true;

  title = 'forms-assignment';
}
