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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        return clientList != null ? clientList.equals(client.clientList) : client.clientList == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (clientList != null ? clientList.hashCode() : 0);
        return result;
    }
}
