import { Component } from '@angular/core';
import { CircleComponent } from './circle/circle.component';
import { FormsModule } from '@angular/forms';
import { CurrencyConverterComponent } from './currency-converter/currency-converter.component';
import { ServicesComponent } from './services/services.component';

@Component({
  selector: 'app-root',
  imports: [CircleComponent, FormsModule, CurrencyConverterComponent, ServicesComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'app';
}
