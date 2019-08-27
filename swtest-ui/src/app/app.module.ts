import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { SwtestService } from './services/swtest.service';
import { AdimComponent } from './components/adim/adim.component';

@NgModule({
  declarations: [
    AppComponent,
    AdimComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
	HttpClientModule
  ],
  providers: [SwtestService],
  bootstrap: [AppComponent]
})
export class AppModule { }
