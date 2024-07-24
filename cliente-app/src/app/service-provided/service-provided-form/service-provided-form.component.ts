import { Component, OnInit } from '@angular/core';
import { Client } from 'src/app/clients/client';
import { ClientsService } from '../../clients.service';
import { ServiceProvided } from '../service-provided';
import { ServiceProvidedService } from '../../service-provided.service';

@Component({
  selector: 'app-service-provided-form',
  templateUrl: './service-provided-form.component.html',
  styleUrls: ['./service-provided-form.component.css']
})
export class ServiceProvidedFormComponent {

  clients: Client[]= [];
  serviceProvided: ServiceProvided;
  success: boolean = false;

  constructor(
    private clientService: ClientsService,
    private service: ServiceProvidedService
  ) {
    this.serviceProvided = new ServiceProvided();
   }

  ngOnInit(): void {
    this.clientService
      .getClients()
      .subscribe( response => this.clients = response );
  }

  onSubmit() {
    this.service
      .save(this.serviceProvided)
      .subscribe({
        next: res => {
          this.success = true;
          this.serviceProvided = new ServiceProvided();
        },
        error: (error) => {
          console.error('Error updating client:', error);
          // Handle update error (optional)
        }
      });
  }
}
