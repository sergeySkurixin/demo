package hibernate.test.repository;

import hibernate.test.entity.BankToClient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by скурихин on 23.11.2016.
 */
public interface BankToClientRepository extends JpaRepository<BankToClient, Long> {
}
