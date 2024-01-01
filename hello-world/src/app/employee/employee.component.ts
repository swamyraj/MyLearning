import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TestService } from '../test.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.scss'
})
export class EmployeeComponent implements OnInit{

  public employees: any;
constructor(private employeeService :TestService, private router: Router){
}
  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(data=> this.employees=data);
  }

  onselect(employee: any){
    this.router.navigate(['employee-details',employee.id]);
  }
}
