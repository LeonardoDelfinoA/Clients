import { Component, OnInit } from '@angular/core';
import { Client } from '../client';
import { ClientsService } from '../../clients.service';
import { Router, ActivatedRoute } from "@angular/router";
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-clients-form',
  templateUrl: './clients-form.component.html',
  styleUrls: ['./clients-form.component.css']
})
export class ClientsFormComponent implements OnInit {

  client: Client;
  success: boolean = false;
  id?:number;

  constructor( 
    private service: ClientsService ,
    private router: Router,
    private activatedRoute: ActivatedRoute
    ) {
    this.client = new Client();
   }

  ngOnInit(): void {

    this.activatedRoute.params.subscribe({
      next: (params) => {
        if (params['id']) {
          this.id = params['id'] as number;
          this.service.getClientById(this.id).subscribe(client => {
            this.client = client
          });
        }
      },
      error: (error) => {
        console.error('Error fetching client:', error);
      }
    })
  }

  goBackToList() {
    this.router.navigate(['clients-list'])
  }

  onSubmit() {

    if(this.id) {
      this.service.update(this.client).subscribe({
        next: res => {
          this.success = true;
          // Handle successful update (optional)
        },
        error: (error) => {
          console.error('Error updating client:', error);
          // Handle update error (optional)
        }
      });
    } else {


      this.service
        .save(this.client)
          .subscribe( response => {
            this.success = true;
            this.client= response;
          })
    }

  }
}
