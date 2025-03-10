import { Component } from '@angular/core';
import { FormComponent } from './form/form.component';
import { ParagraphComponent } from './paragraph/paragraph.component';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-deposit',
  imports: [FormComponent, ParagraphComponent, CommonModule],
  templateUrl: './deposit.component.html',
  styleUrl: './deposit.component.css'
})
export class DepositComponent {
  isFormVisible = false; 

  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }
}
