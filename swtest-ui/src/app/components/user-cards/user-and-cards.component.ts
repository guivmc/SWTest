import { Component, OnInit } from '@angular/core';
import { SwtestService } from '../../services//swtest.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-and-cards',
  templateUrl: './user-and-cards.component.html',
  styleUrls: ['./user-and-cards.component.css']
})
export class UserAndCardsComponent implements OnInit {

  public userReg;
  public userCards;

  constructor(private swTestService: SwtestService, private route: ActivatedRoute) { }

  ngOnInit() {
	  this.getUserReg(this.route.snapshot.params.id);
  }
  
  getUserReg(id:number){
	  this.swTestService.getUser(id).subscribe(
	  data => { this.userReg = data; },
	  err => console.error(err),
	  () => console.log('User Loaded')
	  );
	  
	  this.getUserCards(id);
  }
  
  getUserCards(idUser:number){
	  this.swTestService.getUserCards(idUser).subscribe(
	  data => { this.userCards = data; },
	  err => console.error(err),
	  () => console.log('User Loaded')
	  );
  }

}
