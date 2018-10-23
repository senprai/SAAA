package sut.sa.g15.entity;

import lombok.NonNull;


import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity

public class Queue {
    @Id
    @SequenceGenerator(name = "queue_seq",sequenceName = "queue_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "queue_seq")
    @Column(name = "QUEUE_ID")
    private @NonNull Long queueID;
    @Temporal(TemporalType.DATE)
    private @NonNull Date dateAppointment;
    @Temporal(TemporalType.DATE)
    private @NonNull Date dateQueue;
    private @NonNull double baseAmount;


    @ManyToOne
    @JoinColumn(name = "MEMBERS_USER",nullable = false)
    private Members members;

    @ManyToOne
    @JoinColumn(name = "SERVICE_CENTER_ID",nullable = false)
    private ServiceCenter serviceCenter;

    public Queue() { }

    public Queue(Date dateAppointment, Date date, double baseAmount , Members members, ServiceCenter serviceCenter) {
        this.dateAppointment = dateAppointment;
        this.dateQueue = date;
        this.baseAmount = baseAmount;
        this.members = members;
        this.serviceCenter = serviceCenter;
    }

    public Long getQueueID() {
        return queueID;
    }

    public void setQueueID(Long queueID) {
        this.queueID = queueID;
    }

    public Date getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(Date dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public Date getDateQueue() {
        return dateQueue;
    }

    public void setDateQueue(Date dateQueue) {
        this.dateQueue = dateQueue;
    }

    public double getBaseAmount() {
        return baseAmount;
    }

    public void setBaseAmount(double baseAmount) {
        this.baseAmount = baseAmount;
    }

    public Members getMembers() {
        return members;
    }

    public void setMembers(Members members) {
        this.members = members;
    }

    public ServiceCenter getServiceCenter() {
        return serviceCenter;
    }

    public void setServiceCenter(ServiceCenter serviceCenter) {
        this.serviceCenter = serviceCenter;
    }
}

