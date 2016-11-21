package hibernate.test.repository;

import hibernate.test.entity.Bank;
import hibernate.test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

/**
 * Created by скурихин on 21.11.2016.
 */
public interface BankRepository extends JpaRepository<Bank, Long> {

    Bank findByName(String name);

}
