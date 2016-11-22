package hibernate.test.service.impl;

import hibernate.test.entity.Bank;
import hibernate.test.entity.BankToClient;
import hibernate.test.entity.Client;
import hibernate.test.repository.BankRepository;
import hibernate.test.repository.BankToClientRepository;
import hibernate.test.repository.ClientRepository;
import hibernate.test.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * Created by скурихин on 23.11.2016.
 */
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    private LocalContainerEntityManagerFactoryBean factoryBean;

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private BankToClientRepository bankToClientRepository;


    @Override
    public BankToClient addClientToBank(Bank bank, Client client) {
        BankToClient bankToClient = bankToClientRepository.saveAndFlush(new BankToClient(bank, client));
        return null;
    }
}
