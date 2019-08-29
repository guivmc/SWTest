import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdimComponent } from './components/adim/adim.component';
import { HomeComponent } from './components/home/home.component';
import { ViewRegistrationComponent } from './components/view-registration/view-registration.component';
import { UserAndCardsComponent } from './components/user-cards/user-and-cards.component';

const routes: Routes = [
	{   
		path: 'adim/usercards/:id',
		component: UserAndCardsComponent
	},
	{
		path: 'adim/view/:id',
		component: ViewRegistrationComponent
	},
	{
		path:'adim',
		component: AdimComponent
	},
	{
		path: '',
		component: HomeComponent
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
