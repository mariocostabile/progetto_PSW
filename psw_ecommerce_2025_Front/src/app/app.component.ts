import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AdminComponent } from "./components/admin/admin.component";
import { UserComponent } from "./components/user/user.component";
import { NavbarComponent } from "./components/navbar/navbar.component";


@Component({
  selector: 'app-root',
  imports: [AdminComponent, UserComponent, NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'eahbah';
}


