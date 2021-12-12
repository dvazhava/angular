import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(private http:HttpClient) { }

  private baseurl='http://localhost:8050/getAllCustomerDetails';
  //private baseurl='http://localhost:8056/getAllCustomerDetails';
  private createurl='http://localhost:8050/createCustomer';
  private customerurl='http://localhost:8050/updateById';
  private deleteurl='http://localhost:8050/delete';
  private geturl='http://localhost:8050/customer';

  getCustomer(id:number) : Observable<any>{
    return this.http.get(`${this.geturl}/${id}`);
  }

  createCustomer(customer:Object):Observable<Object>{
    return this.http.post(`${this.createurl}`,customer);
  }

  updateCustomer(id:number,value:any):Observable<any>{
    return this.http.put(`${this.customerurl}/${id}`,value);
  }

  deleteCustomer(id:number):Observable<any>{
    return this.http.delete(`${this.deleteurl}/${id}`,{ responseType: 'text' });
  }

  getCustomerList():Observable<any>{
    return this.http.get(`${this.baseurl}`);
  }
}
