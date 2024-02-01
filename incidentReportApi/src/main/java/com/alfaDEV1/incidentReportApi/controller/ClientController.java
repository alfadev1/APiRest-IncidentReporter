package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.ClientDTO;
import com.alfaDEV1.incidentReportApi.persistence.dto.ServiceDTO;
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
    @PostMapping
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        //TODO Estas condiciones pueden ser reemplazadas por el validador @NotNull https://www.javaguides.net/2021/04/spring-boot-dto-validation-example.html
        if (clientDTO.getName().isBlank() || clientDTO.getLastName().isBlank() || clientDTO.getCuit() == null) {
            return ResponseEntity.badRequest().build();
        }
        final long clientId = clientService.saveClient(clientDTO);
        return ResponseEntity.created(new URI("/api/clients/" + clientId)).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable Long id) {
        Optional<ClientDTO> clientOptional = clientService.findClientById(id);
        if(clientOptional.isPresent()) {
            clientService.deleteClientById(id);
            return ResponseEntity.ok("Register Deleted");
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{idClient}/hiredServices")
    public ResponseEntity<List<ServiceDTO>> findHiredServicesByIdClient(@PathVariable Long idClient) {
        //TODO Búsqueda en base de datos duplicada, se puede optimizar
        Optional<ClientDTO> clientOptional = clientService.findClientById(idClient);
        if(clientOptional.isPresent()) {
            List<ServiceDTO> serviceDTOList = clientService.findHiredServicesByIdClient(idClient);
            return ResponseEntity.ok(serviceDTOList);
        }
        return ResponseEntity.badRequest().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findClientById(@PathVariable Long id) {
        Optional<ClientDTO> clientOptional = clientService.findClientById(id);
        return clientOptional.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAllClients() {
        List<ClientDTO> clientDTOList = clientService.findAllClients();
        return  ResponseEntity.ok(clientDTOList);
    }

    @PutMapping("/{idClient}/hiredServices/{idService}")
    public ResponseEntity<String> addServiceToClient(@PathVariable Long idClient, @PathVariable Long idService) {
        Optional<ClientDTO> optionalClient = clientService.findClientById(idClient);
        Optional<Service> optionalService = serviceService.findServiceById(idService);
        if (optionalClient.isEmpty() || optionalService.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        clientService.addServiceToClient(idClient, idService);
        return ResponseEntity.ok("Service added to client");
    }

}




















