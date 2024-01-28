package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    void saveClient(Client client);
    void deleteClientById(Long id);
    Optional<Client> findClientById(Long id);
    List<Client> findAllClients();
    void addServiceToClient(Long idClient, Long idService);
}
