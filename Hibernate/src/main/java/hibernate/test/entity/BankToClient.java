package hibernate.test.entity;

import javax.persistence.*;

/**
 * Created by скурихин on 23.11.2016.
 */
@Entity
@Table(name = "bank_client")
public class BankToClient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Client client;

    protected BankToClient() {
    }

    public BankToClient(Bank bank, Client client) {
        this.bank = bank;
        this.client = client;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Client getClient() {
        return client;
    }

    @Override
    public String toString() {
        return "BankToClient{" +
                "id=" + id +
                ", bank=" + bank.getName() +
                ", client=" + client.getName() +
                '}';
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
