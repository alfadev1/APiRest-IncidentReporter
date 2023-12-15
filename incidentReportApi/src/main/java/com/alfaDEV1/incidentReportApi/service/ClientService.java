package com.alfaDEV1.incidentReportApi.service;

import com.alfaDEV1.incidentReportApi.persistence.dao.IClientDAO;
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
}
