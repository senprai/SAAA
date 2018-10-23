package sut.sa.g15.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.CurrencyType;
import sut.sa.g15.entity.Queue;
import sut.sa.g15.entity.QueueCurrency;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public interface QueueCurrencyRepository extends JpaRepository<QueueCurrency, Long> {
    Collection<QueueCurrency> findByQueue(Queue queue);
    QueueCurrency findByQueueAndCurrencyType(Queue queue, CurrencyType currencyType);

}
