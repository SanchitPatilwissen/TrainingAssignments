import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CurrencyConversionPipe } from '../currency-conversion.pipe';

@Component({
  selector: 'app-currency-converter',
  imports: [FormsModule, CommonModule, CurrencyConversionPipe],
  templateUrl: './currency-converter.component.html',
  styleUrl: './currency-converter.component.css'
})
export class CurrencyConverterComponent {
  amount: number = 0;
  fromCurrency: string = 'INR';
  toCurrency: string = 'USD';
}
