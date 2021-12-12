import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Customer } from 'src/app/modells/customer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-listcustomer',
  templateUrl: './listcustomer.component.html',
  styleUrls: ['./listcustomer.component.css']
})
export class ListcustomerComponent implements OnInit {

  customer:any;
  constructor(private customerservice:CustomerService,private route:Router) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData(){
    this.customer=this.customerservice.getCustomerList();
  }

  deleteCustomer(id:number){
    this.customerservice.deleteCustomer(id).subscribe(
      data => {
        console.log(data);
        this.reloadData();
      },
      error => console.log(error));
  }

  customerDetails(id:number){
    this.route.navigate(['customer',id]);
  }

  updateCustomer(id:number){
    this.route.navigate(['updateById',id]);
  }


}
