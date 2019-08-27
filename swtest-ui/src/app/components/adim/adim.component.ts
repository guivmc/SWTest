import { Component, OnInit } from '@angular/core';
import { SwtestService } from '../../services//swtest.service';
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-adim',
  templateUrl: './adim.component.html',
  styleUrls: ['./adim.component.css']
})
export class AdimComponent implements OnInit {

  public users;

  constructor(private swTestService: SwtestService) { }

  ngOnInit() {
	  this.getUsers();
  }

  getUsers(){
	  this.swTestService.getUsers().subscribe(
		data => { this.users = data},
		err => console.error(err),
		() => console.log('Users foi')
	  );
  }

}
