package com.alfaDEV1.incidentReportApi.controller;

import com.alfaDEV1.incidentReportApi.persistence.dto.ClientDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/clients")

public class ClientController {

    @Autowired
    private IClientService clientService;

    @PostMapping("/saveClient")
    public ResponseEntity<?> saveClient(@RequestBody ClientDTO clientDTO) throws URISyntaxException {
        if (clientDTO.getName().isBlank() || clientDTO.getLastName().isBlank() || clientDTO.getCuit() == null) {
            return ResponseEntity.badRequest().build();
        }
        clientService.saveClient(Client.builder()
                .name(clientDTO.getName())
                .lastName(clientDTO.getLastName())
                .cuit(clientDTO.getCuit())
                .companyName("null")
                .build());
        return ResponseEntity.created(new URI("/api/clients/saveClient")).build();
    }

}
