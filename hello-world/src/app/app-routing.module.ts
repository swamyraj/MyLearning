import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { DepartmentDetailComponent } from './department-detail/department-detail.component';
import { DepartmentComponent } from './department/department.component';
import { EmployeeDetailComponent } from './employee-detail/employee-detail.component';
import { EmployeeComponent } from './employee/employee.component';
import { NotfoundComponent } from './notfound/notfound.component';


const routes: Routes = [
  //{path:'',component:AppComponent},
  {path:'',redirectTo:'/department',pathMatch:'full'},
  {path:'employee',component : EmployeeComponent},
  {path:'department',component:DepartmentComponent},
  {path:'employee-details/:id',component:EmployeeDetailComponent},
  {path:'**',component:NotfoundComponent} //should be always at the last
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

export const RoutingComponent = [
  EmployeeComponent,
  EmployeeDetailComponent,
  DepartmentComponent,
  DepartmentDetailComponent,
  NotfoundComponent
];
