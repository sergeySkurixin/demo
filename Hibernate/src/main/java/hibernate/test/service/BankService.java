package hibernate.test.service;

import hibernate.test.entity.Bank;
import hibernate.test.entity.Client;

import java.util.List;

/**
 * Created by скурихин on 21.11.2016.
 */
public interface BankService {

    Bank addBank(Bank bank);

    Bank findByName(String name);

    List<Client> findClientsByBank(Bank bank);

    List<Bank> getAll();
}
