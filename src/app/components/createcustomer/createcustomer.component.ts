import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from 'src/app/modells/customer.model';
import { CustomerService } from 'src/app/services/customer.service';


@Component({
  selector: 'app-createcustomer',
  templateUrl: './createcustomer.component.html',
  styleUrls: ['./createcustomer.component.css']
})
export class CreatecustomerComponent implements OnInit {
  
  customer:Customer = new Customer();
  submitted = false;
  constructor(private customerservice:CustomerService,private route:Router) {
    
   }
   

  ngOnInit(): void {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  save() {
    this.customerservice
    .createCustomer(this.customer).subscribe(data => {
      console.log(data)
      this.customer = new Customer();
      this.gotoList();
    }, 
    error => console.log(error));
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.route.navigate(['/createCustomer']);
  }


}
