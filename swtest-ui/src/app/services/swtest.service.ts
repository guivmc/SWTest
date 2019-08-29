import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

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
	  return this.http.get('/server/server/rest/list');
  }
  
  getUser(id: number){
	  return this.http.get('/server/server/rest/findUser/' + id);
  }
  
  getUserCards(id: number){
	  return this.http.get('/server/server/rest/findUserCards/' + id);
  }
  
  createUser(user){
	  let body = JSON.stringify(user);
	   return this.http.post('/server/server/rest/add', body, httpOptions );
  }
}
