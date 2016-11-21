package hibernate.test.service.impl;

import hibernate.test.entity.Client;
import hibernate.test.repository.ClientRepository;
import hibernate.test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by скурихин on 21.11.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Client findByName(String name) {
        return null;
    }
}
