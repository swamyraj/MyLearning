import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { TestService } from '../test.service';

@Component({
  selector: 'app-test',
  //selector: '.app-test'  -- in html we can use as class in div    <div class="app-test"></div>
  //selector: '[app-test]' -- in html we can use as attribute in div    <div app-test></div>
  templateUrl: './test.component.html',
  styleUrl: './test.component.scss'
})
export class TestComponent implements OnInit{

  public name="swamy!";
  public myId ="testId";

  public greetUser(){
    return "Hello "+ this.name;
  }
  
  public isDisabled = true;
  public testSuccess="text-success";
  public hasError = false;
  public isSpecial = true;

  public messagesClass = {
    "text-success":!this.hasError,
    "text-danger":this.hasError,
    "text-special":this.isSpecial
  }

  public highlightColor="pink";
  public titleStyles= {
      color: 'violet',
      fontStyle:'italic'
  }

  public greeting1="";
  public onClick(event: { type: string; }){
    console.log("Welcome click event : "+ event.type);
    this.greeting1 = "Event binding test";
  }
  public greeting2="";
  public logMessage(myName: string){
    this.greeting2 = "Tempate reference test : "+myName;
  }

  public twoWayBind="Im twoWayBind...";
  public testNgIf1 = true;
  public testNgIf2 = false;
  public testNgIf3 = false;
  public colorName = "orange";
  
  public colors =["red","green","yellow"];

  @Input('parentData') public pname: any;
  @Output() public childEvent = new EventEmitter();

  public sendToParent(){
    this.childEvent.emit("I am from child event");
  }


  public person = {
    name : "swamy",
    age : 21
  }
public date =new Date();



public employees: any;
constructor(private employeeService :TestService){
}
  ngOnInit(): void {
    this.employeeService.getEmployees().subscribe(data=> this.employees=data);
  }




}
