package hibernate.test.service;

import hibernate.test.entity.Bank;
import hibernate.test.entity.Client;

/**
 * Created by скурихин on 21.11.2016.
 */
public interface ClientService {

    Client addClient(Client client);

    Client findByName(String name);

}
