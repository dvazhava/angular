import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreatecustomerComponent } from './components/createcustomer/createcustomer.component';
import { CustomerdetailsComponent } from './components/customerdetails/customerdetails.component';
import { ListcustomerComponent } from './components/listcustomer/listcustomer.component';
import { UpdatecustomerComponent } from './components/updatecustomer/updatecustomer.component';
import { ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    CreatecustomerComponent,
    CustomerdetailsComponent,
    ListcustomerComponent,
    UpdatecustomerComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
