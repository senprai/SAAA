package sut.sa.g15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sut.sa.g15.entity.ServiceCenter;
import sut.sa.g15.repository.ServiceCenterRepository;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceCenterController {
    @Autowired
    private ServiceCenterRepository serviceCenterRepository;

    @GetMapping("/service-center")
    public Collection<ServiceCenter> getServiceCenter() {
        return serviceCenterRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/service-centerone/{serviveone}")
    public ServiceCenter getOneServiceCenter(@PathVariable Long serviveone) {
        return serviceCenterRepository.findById(serviveone).get();
    }
}
