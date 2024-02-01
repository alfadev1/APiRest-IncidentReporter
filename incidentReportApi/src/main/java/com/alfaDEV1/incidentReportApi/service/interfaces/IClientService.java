package com.alfaDEV1.incidentReportApi.service.interfaces;

import com.alfaDEV1.incidentReportApi.persistence.dto.ClientDTO;
import com.alfaDEV1.incidentReportApi.persistence.dto.ServiceDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.persistence.entity.Service;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    long saveClient(ClientDTO client);
    void deleteClientById(Long id);
    Optional<ClientDTO> findClientById(Long id);
    List<ClientDTO> findAllClients();
    void addServiceToClient(Long idClient, Long idService);
    List<ServiceDTO> findHiredServicesByIdClient(Long idClient);
}
