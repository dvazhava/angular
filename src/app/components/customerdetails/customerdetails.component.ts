import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Customer } from 'src/app/modells/customer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-customerdetails',
  templateUrl: './customerdetails.component.html',
  styleUrls: ['./customerdetails.component.css']
})
export class CustomerdetailsComponent implements OnInit {

  id: any;
  customer: any;
  constructor(private customerservice:CustomerService,private router:Router,private route:ActivatedRoute) { }

  ngOnInit(){
    this.customer = new Customer();

    this.id = this.route.snapshot.params['id'];
    
    this.customerservice.getCustomer(this.id)
      .subscribe(data => {
        console.log(data);
        this.customer = data;
      }, error => console.log(error));
  }

  list(){
    this.router.navigate(['customer']);
  }

}
