package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.Currency;
import sut.sa.g15.repository.CurrencyRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyController {
    @Autowired
    private CurrencyRepository currencyRepository;

    @GetMapping(path = "/currency", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Currency> getCurrency() {
        return currencyRepository.findAll().stream().collect(Collectors.toList());

    }

    @GetMapping(path = "/currencyone/{currencyCo}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Currency getOneCurrency(@PathVariable String currencyCo) {
        return currencyRepository.findById(currencyCo).get();
    }
}
