package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IClientDAO;
import com.alfaDEV1.incidentReportApi.persistence.dao.IServiceDAO;
import com.alfaDEV1.incidentReportApi.persistence.dto.ClientDTO;
import com.alfaDEV1.incidentReportApi.persistence.dto.ServiceDTO;
import com.alfaDEV1.incidentReportApi.persistence.entity.Client;
import com.alfaDEV1.incidentReportApi.service.interfaces.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ClientService implements IClientService {
    @Autowired
    private IClientDAO clientDAO;
    @Autowired
    private IServiceDAO serviceDAO;

    @Override
    public long saveClient(ClientDTO clientDTO) {
        final Client client = Client.builder()
            .name(clientDTO.getName())
            .lastName(clientDTO.getLastName())
            .cuit(clientDTO.getCuit())
            .companyName(clientDTO.getCompanyName())
            .build();
        return clientDAO.saveClient(client).getId();
    }

    @Override
    public void deleteClientById(Long id) {
        clientDAO.deleteClientById(id);
    }

    @Override
    public Optional<ClientDTO> findClientById(Long id) {
        return clientDAO.findClientById(id).map(ClientService::mapClientToClientDTO);
    }

    @Override
    public List<ClientDTO> findAllClients() {
        return clientDAO.findAllClients().stream().map(ClientService::mapClientToClientDTO).toList();
    }
    @Override
    public void addServiceToClient(Long idClient, Long idService) {
        Client client = clientDAO.findClientById(idClient).get();
        com.alfaDEV1.incidentReportApi.persistence.entity.Service service = serviceDAO.findServiceById(idService).get();
        List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> serviceList = client.getServiceList();
        serviceList.add(service);
        client.setServiceList(serviceList);
        clientDAO.saveClient(client);
    }

    @Override
    public List<ServiceDTO> findHiredServicesByIdClient(Long idClient) {
        Client client = clientDAO.findClientById(idClient).get();
        List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> serviceList = client.getServiceList();
        return serviceList.stream().map(ClientService::mapServiceToServiceDTO).toList();
    }
    
    //TODO Mover a un servicio mapper
    private static ServiceDTO mapServiceToServiceDTO(com.alfaDEV1.incidentReportApi.persistence.entity.Service service) {
        return ServiceDTO.builder()
                .name(service.getName())
                .description(service.getDescription())
                .build();
    }
    
    //TODO Mover a un servicio mapper
    private static ClientDTO mapClientToClientDTO(Client client) {
        return ClientDTO.builder()
            .companyName(client.getCompanyName())
            .name(client.getName())
            .lastName(client.getLastName())
            .cuit(client.getCuit())
            .build();
    }
}
