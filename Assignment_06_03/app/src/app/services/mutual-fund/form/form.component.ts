import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [FormsModule, CommonModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  amount: number = 0; 
  rate: number = 7; 
  tenure: number = 1; 
  maturityValue: number = 0; 
  isMaturityVisible: boolean = false; 

  formValid(): boolean {
    return this.amount > 0 && this.tenure >= 1 && this.tenure <= 10;
  }

  handleSubmit(): void {
    if (this.formValid()) {
      const r = this.rate / 1200;
      this.maturityValue = this.amount * ((Math.pow(1 + r, this.tenure) - 1) / r) * (1 + r);
      this.isMaturityVisible = true;
    } else {
      alert('Please enter a valid amount and tenure!');
    }
  }
}
