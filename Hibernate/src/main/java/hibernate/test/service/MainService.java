package hibernate.test.service;

import hibernate.test.entity.Bank;
import hibernate.test.entity.BankToClient;
import hibernate.test.entity.Client;

/**
 * Created by скурихин on 23.11.2016.
 */
public interface MainService {

    BankToClient addClientToBank(Bank bank, Client client);
}
