import { Component, OnInit } from '@angular/core';
import { SwtestService } from '../../services//swtest.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
	
  userForm: FormGroup;
  validMessage: string = "";
  
  number: string;

  constructor(private swTestService: SwtestService, private router: Router) { }

  ngOnInit() {
	  this.userForm = new FormGroup({
		  name: new FormControl('', Validators.required),
		  email: new FormControl('', Validators.required),
		  identifier: new FormControl('', Validators.required)
	  });
  }

  submitRegistration(){
	  if(this.userForm.valid){
		
		this.swTestService.createUser(this.userForm.value).subscribe(
			data => { 
				this.userForm.reset();
				return true;
			},
			succ => { this.validMessage = "foi"; }
		)
	  }
	  else{
		  this.validMessage = "Não foi";
	  }
  }
  
  btnClick= function () {
        this.router.navigateByUrl('/adim');
  };
  
  serachUser() {
		this.router.navigateByUrl('adim/view/' + this.number);
  }

}
