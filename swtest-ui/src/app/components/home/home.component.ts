import { Component, OnInit } from '@angular/core';
import { SwtestService } from '../../services//swtest.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Observable } from 'rxjs/Observable';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
	
  userForm: FormGroup;
  validMessage: string = "";

  constructor(private swTestService: SwtestService) { }

  ngOnInit() {
	  this.userForm = new FormGroup({
		  name: new FormControl('', Validators.required),
		  email: new FormControl('', Validators.required)
	  });
  }

  submitRegistration(){
	  if(this.userForm.valid){
		this.validMessage = "foi";
		this.swTestService.createUser(this.userForm.value).subscribe(
			data => { 
				this.userForm.reset();
				return true;
			},
			error => { return Observable.throw(error); }
		)
	  }
	  else{
		  this.validMessage = "Não foi";
	  }
  }

}
