package hibernate.test.service.impl;

import hibernate.test.entity.Client;
import hibernate.test.repository.ClientRepository;
import hibernate.test.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created by скурихин on 21.11.2016.
 */
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private LocalContainerEntityManagerFactoryBean factoryBean;

    @Override
    public Client addClient(Client client) {
        return clientRepository.saveAndFlush(client);
    }

    @Override
    public Client findByName(String name) {
//        CriteriaBuilder builder = factoryBean.getObject().getCriteriaBuilder();
//        Root<Client> from = builder.createQuery(Client.class).from(Client.class);

        return null;
    }
}
