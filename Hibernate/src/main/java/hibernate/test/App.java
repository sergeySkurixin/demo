package hibernate.test;

import hibernate.test.config.ApplicationConfiguration;
import hibernate.test.entity.Bank;
import hibernate.test.entity.Client;
import hibernate.test.service.BankService;
import hibernate.test.service.ClientService;
import org.hibernate.Hibernate;
import org.jboss.logging.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by скурихин on 21.11.2016.
 */
public class App {

    static final Logger LOGGER = Logger.getLogger(App.class);

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        BankService bankService = context.getBean(BankService.class);
        ClientService clientService = context.getBean(ClientService.class);
        Bank vtb = new Bank("vtb");
        Bank gazProm = new Bank("gazProm");
        Bank bankCreate1 = bankService.addBank(vtb);
        Bank bankCreate2 = bankService.addBank(gazProm);
        LOGGER.info(bankCreate1);
        LOGGER.info(bankCreate2);

        Client bob = new Client("Bob", vtb);
        Client rob = new Client("Rob", vtb);
        Client fill = new Client("Fill", gazProm);
        Client client = clientService.addClient(bob);
        Client client1 = clientService.addClient(rob);
        Client client2 = clientService.addClient(fill);

        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.out.println(bankService.getAll().toString());
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");

    }
}
