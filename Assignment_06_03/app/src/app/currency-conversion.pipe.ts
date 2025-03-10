import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'currencyConversion',
  pure: true
})
export class CurrencyConversionPipe implements PipeTransform {

  transform(value: number, ...args: string[]): number {
    let fromCurrency = args[0];
    let toCurrency = args[1];
    
    const exchangeRatesINR : { [key: string]: number } = {
      'INR':1, 
      'USD':85, 
      'EUR':90, 
      'JPY':0.67, 
      'SAR':22, 
      'AUD':55
    };

    let fromCurrencyToINR = exchangeRatesINR[fromCurrency];

    let toCurrencyFromINR = exchangeRatesINR[toCurrency];

    let amountInINR = value * fromCurrencyToINR;
    let convertedAmount = amountInINR / toCurrencyFromINR;

    return convertedAmount;

  }

}
