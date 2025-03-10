import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-form',
  imports: [CommonModule, FormsModule],
  templateUrl: './form.component.html',
  styleUrl: './form.component.css'
})
export class FormComponent {
  fullName: string = '';

  emi:number = 0;

  isVisible: boolean = false;
  minAmount: number = 0;
  maxAmount: number = 0;
  minTenure: number = 0;
  maxTenure: number = 0;
  rate: number = 9;
  loanType:string = "";

  amount = 0;
  tenure = 0;

  isEmiVisible: boolean = false;

  toggleVisibility() {
    if (this.loanType === 'home') {
      this.rate = 9;
      this.minAmount = 100000;
      this.maxAmount = 50000000;
      this.minTenure = 1;
      this.maxTenure = 30;
    } else if (this.loanType === 'car') {
      this.rate = 11;
      this.minAmount = 50000;
      this.maxAmount = 1000000;
      this.minTenure = 1;
      this.maxTenure = 7;
    } else if (this.loanType === 'personal') {
      this.rate = 15;
      this.minAmount = 10000;
      this.maxAmount = 500000;
      this.minTenure = 1;
      this.maxTenure = 5;
    }
    this.isVisible = true;
  }

  tenurePlaceholder(){
    return "Must be from "+this.minTenure+" to "+this.maxTenure+" years";
  }

  amountPlaceholder(){
    return "Must be from "+this.minAmount+" to "+this.maxAmount+" rupees";
  }

  handleSubmit(form: any){
    if(form.valid){
      console.log(this.amount);
      console.log(typeof(this.amount));
      var r_value= (this.rate/(12*100));
      var val = (1+r_value)**this.tenure;
      this.isEmiVisible = true;
      this.emi = Math.round((r_value*this.amount*val)/(val-1));
    }
  }
}
