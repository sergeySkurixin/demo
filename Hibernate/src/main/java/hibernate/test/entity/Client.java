package hibernate.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by скурихин on 21.11.2016.
 */
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

//    @ManyToOne(fetch = FetchType.EAGER, optional = true)
//    @JoinTable(name = "bank_client",
//            joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "id_bank", referencedColumnName = "id"))
//    private Bank bank;

//    @Column(table = "bank_client", name = "amount")
//    private Long amount;

    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<BankToClient> clientList;

    protected Client() {
    }

    public Client(String name) {
        this(name,new ArrayList<BankToClient>());
    }

    public Client(String name, List<BankToClient> clientList) {
        this.name = name;
        this.clientList = clientList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BankToClient> getClientList() {
        return clientList;
    }

    public void setClientList(List<BankToClient> clientList) {
        this.clientList = clientList;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
