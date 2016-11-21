package hibernate.test.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by скурихин on 21.11.2016.
 */
@Entity
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "bank", fetch = FetchType.EAGER)
    private List<Client> clients;

    protected Bank() {
    }

    public Bank(String name) {
        this.name = name;
    }

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bank(String name, List<Client> clients) {
        this.name = name;
        this.clients = clients;
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

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", clients=" + (clients == null ? "null" : clients) +
                '}';
    }
}
