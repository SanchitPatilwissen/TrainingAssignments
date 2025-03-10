import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  amount: number = 0; // Amount entered by the user
  rate: number = 7; // Fixed interest rate (7% for this example)
  tenure: number = 1; // Loan tenure entered by the user
  maturityValue: number = 0; // The calculated maturity amount
  isMaturityVisible: boolean = false; // Flag to show the maturity value after calculation

  // Form validation check
  formValid(): boolean {
    return this.amount > 0 && this.tenure >= 1 && this.tenure <= 10;
  }

  // Handle form submission and calculate maturity value
  handleSubmit(): void {
    if (this.formValid()) {
      // Formula to calculate maturity (Simple Interest Formula)
      const interest = (this.amount * this.rate * this.tenure) / 100;
      this.maturityValue = this.amount + interest;
      this.isMaturityVisible = true; // Show the maturity value
    } else {
      alert('Please enter a valid amount and tenure!');
    }
  }
}
