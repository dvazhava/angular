import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';
import { Customer } from 'src/app/modells/customer.model';
import { CustomerService } from 'src/app/services/customer.service';

@Component({
  selector: 'app-updatecustomer',
  templateUrl: './updatecustomer.component.html',
  styleUrls: ['./updatecustomer.component.css']
})
export class UpdatecustomerComponent implements OnInit {

  id:any;
  customer: any;
  constructor(private route: ActivatedRoute,private customerservice:CustomerService,private router:Router) { }

  ngOnInit() {
    this.customer = new Customer();

    this.id = this.route.snapshot.params['id'];
    this.customerservice.getCustomer(this.id).subscribe(data => {
      console.log(data)
      this.customer = data;
    }, error => console.log(error));
  }

  updateCustomer() {
    this.customerservice.updateCustomer(this.id, this.customer)
      .subscribe(data => {
        console.log(data);
        this.customer = new Customer();
        this.gotoList();
      }, error => console.log(error));
  }

  onSubmit() {
    this.updateCustomer();    
  }

  gotoList() {
    this.router.navigate(['/updateById']);
  }

}
