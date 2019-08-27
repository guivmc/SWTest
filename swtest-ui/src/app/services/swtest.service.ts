import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

const httpOptions = {
	headers: new HttpHeaders({'Content-Type' : 'application/json'})
};


@Injectable({
  providedIn: 'root'
})
export class SwtestService {

  constructor(private http:HttpClient) { }
  
  getUsers()
  {
	  return this.http.get('http://localhost:8080/rest');
  }
}
