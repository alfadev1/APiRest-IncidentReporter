package com.alfaDEV1.incidentReportApi.persistence.dao;

import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;

import java.util.List;
import java.util.Optional;

public interface IClientDAO {
    Client saveClient(Client client);
    void deleteClientById(Long id);
    Optional<Client> findClientById(Long id);
    List<Client> findAllClients();
    /*
    List<Service> findHiredServicesById(Long idClient);
     */
}
