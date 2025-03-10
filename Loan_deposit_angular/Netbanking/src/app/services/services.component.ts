import { Component } from '@angular/core';
import { LoanComponent } from './loan/loan.component';
import { DepositComponent } from './deposit/deposit.component';

@Component({
  selector: 'app-services',
  imports: [LoanComponent, DepositComponent],
  templateUrl: './services.component.html',
  styleUrl: './services.component.css'
})
export class ServicesComponent {

}
