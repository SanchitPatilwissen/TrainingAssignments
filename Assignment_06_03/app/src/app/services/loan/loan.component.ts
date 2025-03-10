import { Component } from '@angular/core';
import { ParagraphComponent } from './paragraph/paragraph.component';
import { FormComponent } from './form/form.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-loan',
  imports: [ParagraphComponent, FormComponent, CommonModule],
  templateUrl: './loan.component.html',
  styleUrl: './loan.component.css'
})
export class LoanComponent {
  isFormVisible = false; 

  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }
}
