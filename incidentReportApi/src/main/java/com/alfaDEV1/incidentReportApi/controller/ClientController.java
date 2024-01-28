package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.ClientDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;
import com.alfaDEV1.incidentReportApi.service.interfaces.IClientService;
import com.alfaDEV1.incidentReportApi.service.interfaces.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;
    @Autowired
    private IServiceService serviceService;
    @PostMapping("/saveClient")
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        if (clientDTO.getName().isBlank() || clientDTO.getLastName().isBlank() || clientDTO.getCuit() == null) {
            return ResponseEntity.badRequest().build();
        }
        clientService.saveClient(Client.builder()
                .name(clientDTO.getName())
                .lastName(clientDTO.getLastName())
                .cuit(clientDTO.getCuit())
                .companyName(clientDTO.getCompanyName())
                .build());
        return ResponseEntity.created(new URI("/api/clients/saveClient")).build();
    }
    @DeleteMapping("/deleteClientById/{id}")
    public ResponseEntity<?> deleteClientById(@PathVariable Long id) {
        Optional<Client> clientOptional = clientService.findClientById(id);
        if(clientOptional.isPresent()) {
            clientService.deleteClientById(id);
            return ResponseEntity.ok("Register Deleted");
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/findClientById/{id}")
    public ResponseEntity<?> findClientById(@PathVariable Long id) {
        Optional<Client> clientOptional = clientService.findClientById(id);
        if(clientOptional.isPresent()) {
            Client client = clientOptional.get();
            ClientDTO clientDTO = ClientDTO.builder()
                    .companyName(client.getCompanyName())
                    .name(client.getName())
                    .lastName(client.getLastName())
                    .cuit(client.getCuit())
                    .build();
            return ResponseEntity.ok(clientDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/findAllClients")
    public ResponseEntity<?> findAllClients() {
        List<ClientDTO> clientDTOList =clientService.findAllClients()
                .stream()
                .map(client -> ClientDTO.builder()
                        .name(client.getName())
                        .lastName(client.getLastName())
                        .cuit(client.getCuit())
                        .build())
                .toList();
        return  ResponseEntity.ok(clientDTOList);
    }

    @PutMapping("/{idClient}/idService/{idService}")
    public ResponseEntity<?> addServiceToClient(@PathVariable Long idClient, @PathVariable Long idService) {
        Optional<Client> optionalClient = clientService.findClientById(idClient);
        Optional<Service> optionalService = serviceService.findServiceById(idService);
        if (!optionalClient.isPresent() || !optionalService.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        clientService.addServiceToClient(idClient, idService);
        return ResponseEntity.ok("Service added to client");
    }

}




















