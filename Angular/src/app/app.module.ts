import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import{NgxPaginationModule} from'ngx-pagination';
import { FormsModule } from '@angular/forms';
import { ViewComponent } from './view/view.component';
import { AddComponent } from './add/add.component';
import { LoginComponent } from './login/login.component';
import{ConfirmationPopoverModule}from 'angular-confirmation-popover';

@NgModule({
  declarations: [
    AppComponent,
    ViewComponent,
    AddComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule,
    ConfirmationPopoverModule.forRoot({
      confirmButtonType:'danger'
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
