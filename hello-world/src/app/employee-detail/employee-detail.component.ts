import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-detail',
  templateUrl: './employee-detail.component.html',
  styleUrl: './employee-detail.component.scss'
})
export class EmployeeDetailComponent {

  public employeeId;
  constructor(private activatedRouter: ActivatedRoute){
  this.employeeId = this.activatedRouter.snapshot.paramMap.get('id');
  }
}
