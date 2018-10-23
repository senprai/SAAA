package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sut.sa.g15.entity.*;
import sut.sa.g15.repository.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class QueueController {
    @Autowired
    private QueueRepository queueRepository;

    @Autowired
    private QueueCurrencyRepository queueCurrencyRepository;

    @Autowired
    private ServiceCenterRepository serviceCenterRepository;

    @Autowired
    private MembersRepository membersRepository;

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @Autowired
    private  UserProfileRepository userProfileRepository;



    @GetMapping(path = "/queue/{queueID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Queue getOneQueue (@PathVariable Long queueID){
        return queueRepository.findById(queueID).get();
    }

    @GetMapping(path = "/queue/user-profile/{memUser}")
    public UserProfile getUserProfileByUserName (@PathVariable String memUser){
        Members members = membersRepository.findById(memUser).get();
        return userProfileRepository.findByMembers(members);
    }

    @PostMapping(path ="/queue/{currencyBase}/{currencyDist}/{serviceID}/{memUser}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Queue newQueue(@RequestBody Queue jsonQueue,
                          @PathVariable String currencyBase,
                          @PathVariable String currencyDist,
                          @PathVariable Long serviceID,
                          @PathVariable String memUser) {


        jsonQueue.setDateQueue(new Date());
        jsonQueue.setServiceCenter(serviceCenterRepository.findById(serviceID).get());
        jsonQueue.setMembers(membersRepository.findById(memUser).get());
        Currency base = currencyRepository.findById(currencyBase).get();
        Currency dist = currencyRepository.findById(currencyDist).get();
        queueRepository.save(jsonQueue);
        QueueCurrency baseJoin = new QueueCurrency(jsonQueue, base, currencyTypeRepository.findByType("Base"));
        QueueCurrency distJoin = new QueueCurrency(jsonQueue, dist, currencyTypeRepository.findByType("Dist"));
        queueCurrencyRepository.save(baseJoin);
        queueCurrencyRepository.save(distJoin);

        return jsonQueue;
    }
    @GetMapping(path = "/queue/currency-type/{queueID}/{type}")
    public QueueCurrency getQueueByCurrencyType(@PathVariable Long queueID,
                                  @PathVariable String type){
        Queue queue = queueRepository.findById(queueID).get();
        CurrencyType currencyType = currencyTypeRepository.findByType(type);
        return queueCurrencyRepository.findByQueueAndCurrencyType(queue, currencyType);

    }

}
