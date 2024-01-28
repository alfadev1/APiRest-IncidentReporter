package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IClientDAO;
import com.alfaDEV1.incidentReportApi.persistence.dao.IServiceDAO;
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
    public void saveClient(Client client) {
        clientDAO.saveClient(client);
    }

    @Override
    public void deleteClientById(Long id) {
        clientDAO.deleteClientById(id);
    }

    @Override
    public Optional<Client> findClientById(Long id) {
        return clientDAO.findClientById(id);
    }

    @Override
    public List<Client> findAllClients() {
        return clientDAO.findAllClients();
    }
    @Override
    public void addServiceToClient(Long idClient, Long idService) {
        List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> serviceList = null;
        Client client = clientDAO.findClientById(idClient).get();
        com.alfaDEV1.incidentReportApi.persistence.entity.Service service = serviceDAO.findServiceById(idService).get();
        serviceList = client.getServiceList();
        serviceList.add(service);
        client.setServiceList(serviceList);
        clientDAO.saveClient(client);
    }

    @Override
    public List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> findHiredServicesByIdClient(Long idClient) {
        List<com.alfaDEV1.incidentReportApi.persistence.entity.Service> serviceList = null;
        Client client = clientDAO.findClientById(idClient).get();
        serviceList = client.getServiceList();
        return serviceList;
    }
}
