import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs';
import { IEmployee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class TestService {

  public url = "/assets/data/employee.json";
  public employees: any;
  public errorMessage="";

  constructor(private http : HttpClient) { }

  public getEmployees() : Observable<IEmployee[]>{
      return this.employees = this.http.get<IEmployee[]>(this.url);
      //.pipe(catchError((err,caught)=>this.errorhandler(err,caught)));
  }

  public errorhandler(error : HttpErrorResponse,o:Observable<IEmployee[]>){
    if(error.error instanceof ErrorEvent){
      // Client-side errors
      this.errorMessage = `Error: ${error.error.message}`;
    }
    else{
      // Server-side errors
      this.errorMessage = `Error Code: ${error.status}\\nMessage: ${error.message}`;
    }
    window.alert(this.errorMessage);
    //return throwError(this.errorMessage);
  }

}
