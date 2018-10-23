package sut.sa.g15.entity;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;


@Entity
public class ServiceCenter {
    @Id
    @SequenceGenerator(name = "service_center_seq",sequenceName ="service_center_seq" )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "service_center_seq")
    @Column(name = "SERVICE_CENTER_ID")
    private @NonNull Long serviceCenID;
    private @NonNull String serviceCenName;
    private @NonNull String serviceCenAddress;
    private @NonNull String serviceCenTel;


    public ServiceCenter() {
    }

    public ServiceCenter(String serviceCenName, String serviceCenAddress, String serviceCenTel) {
        this.serviceCenName = serviceCenName;
        this.serviceCenAddress = serviceCenAddress;
        this.serviceCenTel = serviceCenTel;
    }

    public Long getServiceCenID() {
        return serviceCenID;
    }

    public void setServiceCenID(Long serviceCenID) {
        this.serviceCenID = serviceCenID;
    }

    public String getServiceCenName() {
        return serviceCenName;
    }

    public void setServiceCenName(String serviceCenName) {
        this.serviceCenName = serviceCenName;
    }

    public String getServiceCenAddress() {
        return serviceCenAddress;
    }

    public void setServiceCenAddress(String serviceCenAddress) {
        this.serviceCenAddress = serviceCenAddress;
    }

    public String getServiceCenTel() {
        return serviceCenTel;
    }

    public void setServiceCenTel(String serviceCenTel) {
        this.serviceCenTel = serviceCenTel;
    }
}