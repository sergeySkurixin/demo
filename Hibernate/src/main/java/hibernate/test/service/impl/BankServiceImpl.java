package hibernate.test.service.impl;

import hibernate.test.entity.Bank;
import hibernate.test.entity.Client;
import hibernate.test.repository.BankRepository;
import hibernate.test.service.BankService;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by скурихин on 21.11.2016.
 */
@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public Bank addBank(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public Bank findByName(String name) {
        return bankRepository.findByName(name);
    }

    @Override
    public List<Client> findClientsByBank(Bank bank) {
//        return bankRepository.findClientsByBank(bank);
        return null;
    }

    @Override
    public List<Bank> getAll() {
//        bankRepository.
        List<Bank> banks = bankRepository.findAll();
//        for (Bank bank : banks) {
//            bank.setClients(bankRepository.getListOfClientsByBank(bank));
//            Hibernate.initialize(bank.getClients());
//            Bank one = bankRepository.getOne(bank.getId());
//            List<Client> clients = one.getClients();
//        }
        return banks;
    }
}
