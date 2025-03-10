import { Component } from '@angular/core';
import { LoanComponent } from './loan/loan.component';
import { DepositComponent } from './deposit/deposit.component';
import { MutualFundComponent } from "./mutual-fund/mutual-fund.component";

@Component({
  selector: 'app-services',
  imports: [LoanComponent, DepositComponent, MutualFundComponent],
  templateUrl: './services.component.html',
  styleUrl: './services.component.css'
})
export class ServicesComponent {

}
