import { Component, OnInit } from '@angular/core';
import { SwtestService } from '../../services//swtest.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-view-registration',
  templateUrl: './view-registration.component.html',
  styleUrls: ['./view-registration.component.css']
})
export class ViewRegistrationComponent implements OnInit {
	
  public userReg;

  constructor(private swTestService: SwtestService, private route: ActivatedRoute) { }

  ngOnInit() {
	  this.getUserReg(this.route.snapshot.params.id);
  }

  getUserReg(id:number){
	  this.userReg.getUser(id).subscribe(
	  data => { this.userReg = data; },
	  err => console.error(err),
	  () => console.log('User Loaded')
	  );
  }
}
