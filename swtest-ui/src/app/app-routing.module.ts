import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AdimComponent } from './components/adim/adim.component';

const routes: Routes = [
	{
		path:'adim',
		component: AdimComponent
	}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
