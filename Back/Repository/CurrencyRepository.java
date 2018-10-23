package sut.sa.g15.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import sut.sa.g15.entity.Currency;

@RepositoryRestController
@CrossOrigin(origins = "http://localhost:4200")
public interface CurrencyRepository extends JpaRepository<Currency, String> {
    Currency findByCurrencyCode(String s);
}
