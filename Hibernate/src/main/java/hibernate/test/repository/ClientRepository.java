package hibernate.test.repository;

import hibernate.test.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by скурихин on 21.11.2016.
 */
public interface ClientRepository extends JpaRepository<Client, Long> {
}
