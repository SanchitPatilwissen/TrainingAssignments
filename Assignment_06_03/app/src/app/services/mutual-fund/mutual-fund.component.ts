import { Component } from '@angular/core';
import { FormComponent } from './form/form.component';
import { ParagraphComponent } from './paragraph/paragraph.component';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-mutual-fund',
  imports: [FormComponent, ParagraphComponent, CommonModule],
  templateUrl: './mutual-fund.component.html',
  styleUrl: './mutual-fund.component.css'
})
export class MutualFundComponent {
  isFormVisible = false; 

  toggleForm() {
    this.isFormVisible = !this.isFormVisible;
  }
}
