import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { Customer } from './modells/customer.model';
import { CreatecustomerComponent } from './components/createcustomer/createcustomer.component';
import { CustomerdetailsComponent } from './components/customerdetails/customerdetails.component';
import { ListcustomerComponent } from './components/listcustomer/listcustomer.component';
import { UpdatecustomerComponent } from './components/updatecustomer/updatecustomer.component';

const routes: Routes = [{ path: '', redirectTo: 'getAllCustomerDetails', pathMatch: 'full' },
{ path: 'getAllCustomerDetails', component: ListcustomerComponent },
{ path: 'createCustomer', component: CreatecustomerComponent },
{ path: 'updateById/:id', component: UpdatecustomerComponent },
{ path: 'customer/:id', component: CustomerdetailsComponent },];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
