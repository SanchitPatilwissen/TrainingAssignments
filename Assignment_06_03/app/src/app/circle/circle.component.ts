import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-circle',
  imports: [FormsModule],
  templateUrl: './circle.component.html',
  styleUrl: './circle.component.css'
})
export class CircleComponent {
  radius: number = 0;
}
