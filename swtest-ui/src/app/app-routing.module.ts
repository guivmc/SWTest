import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdimComponent } from './components/adim/adim.component';
import { HomeComponent } from './components/home/home.component';

const routes: Routes = [
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
