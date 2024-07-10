import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { Client } from '../client';
import { ClientsService } from 'src/app/clients.service';

@Component({
  selector: 'app-clients-list',
  templateUrl: './clients-list.component.html',
  styleUrls: ['./clients-list.component.css']
})
export class ClientsListComponent {

  clients: Client[];
  selectedClient: Client = new Client;
  SuccessMessage?: String;
  FailureMessage?: String;

  constructor(
    private service: ClientsService, 
    private router: Router) {
    this.clients = [];
   }

  ngOnInit(): void {
    this.service
      .getClients()
      .subscribe( res => this.clients = res);
  }

  newRegister() {
    this.router.navigate(['/clients-form'])
  }

  prepareDelete(client: Client) {
    this.selectedClient = client;
  }

  deleteClient(){

    this.service.delete(this.selectedClient).subscribe({
      next: res => {
        this.SuccessMessage = 'Cliente deletado com sucesso!'
        this.ngOnInit();
      },
      error: (error) => {
        console.error('Ocorreu um erro ao deletar o cliente', error);
      }
    });
  }
}
