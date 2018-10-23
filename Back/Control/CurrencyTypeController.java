package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.CurrencyType;
import sut.sa.g15.repository.CurrencyTypeRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CurrencyTypeController {
    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @GetMapping(path = "/currency-type", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<CurrencyType> getCurrencyType(){
        return currencyTypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping(path = "/currency-type/{currencyType}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CurrencyType getOneCurrencyType(@PathVariable Long currencyType){
        return currencyTypeRepository.findById(currencyType).get();
    }

}
