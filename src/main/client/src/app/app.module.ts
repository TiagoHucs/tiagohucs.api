import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { SetlistComponent } from './setlist/setlist.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { LocationStrategy, HashLocationStrategy } from '@angular/common';
import { UserService } from './service/user/user.service';
import { AuthGuard } from './security/auth.guard';
import { AuthInterceptor } from './security/auth.interceptor';
import { LoginComponent } from './security/login/login.component';
import { CookieService } from 'ngx-cookie-service';
import { AuthService } from './security/auth.service';
import { JwtHelperService, JwtModule } from '@auth0/angular-jwt';
import { ConfiguracoesComponent } from './configuracoes/configuracoes.component';
import { RoleGuardService } from './security/role.guard.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';

export function tokenGetter() {
  return localStorage.getItem('access_token');
}

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    SetlistComponent,
    LoginComponent,
    ConfiguracoesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule, // required animations module
    ToastrModule.forRoot(), // ToastrModule added
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: ['example.com'],
        blacklistedRoutes: ['example.com/examplebadroute/']
      }
    })

  ],
  providers: [
    UserService, 
    AuthGuard, 
    RoleGuardService,
    AuthService,
    JwtHelperService,
    CookieService,
    { provide: HTTP_INTERCEPTORS,
      useClass: AuthInterceptor,
      multi: true
    },
    { provide: LocationStrategy, useClass: HashLocationStrategy }],
  bootstrap: [AppComponent]
})
export class AppModule { }
