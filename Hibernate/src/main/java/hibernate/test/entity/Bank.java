package hibernate.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private List<BankToClient> bankList;

    protected Bank() {
    }

    public Bank(String name) {
        this(name, new ArrayList<BankToClient>());
    }

    public Bank(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Bank(String name, List<BankToClient> bankList) {
        this.name = name;
        this.bankList = bankList;
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

    public List<BankToClient> getBankList() {
        return bankList;
    }

    public void setBankList(List<BankToClient> bankList) {
        this.bankList = bankList;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", bankList=" + bankList.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bank bank = (Bank) o;

        if (id != null ? !id.equals(bank.id) : bank.id != null) return false;
        if (name != null ? !name.equals(bank.name) : bank.name != null) return false;
        return bankList != null ? bankList.equals(bank.bankList) : bank.bankList == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (bankList != null ? bankList.hashCode() : 0);
        return result;
    }
}
