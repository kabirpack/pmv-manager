package com.app.pmvmanager.serviceticket;

import com.app.pmvmanager.servicecar.ServiceCar;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "service_ticket")
public class ServiceTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ticketId;
    private int lastServiceMileage;
    @Temporal(TemporalType.DATE)
    private Date lastServiceDate;
    private String serviceDescription;
    private Double serviceCost;
    @Temporal(TemporalType.DATE)
    private Date upcomingServiceDate;
    private String serviceEngineerName;
    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @ManyToOne
    private ServiceCar serviceCar;

    public ServiceTicket() {
    }

    public ServiceTicket(int lastServiceMileage, Date lastServiceDate, String serviceDescription, Double serviceCost, Date upcomingServiceDate) {
        this.lastServiceMileage = lastServiceMileage;
        this.lastServiceDate = lastServiceDate;
        this.serviceDescription = serviceDescription;
        this.serviceCost = serviceCost;
        this.upcomingServiceDate = upcomingServiceDate;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getLastServiceMileage() {
        return lastServiceMileage;
    }

    public void setLastServiceMileage(int lastServiceMileage) {
        this.lastServiceMileage = lastServiceMileage;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    public String getServiceDescription() {
        return serviceDescription;
    }

    public void setServiceDescription(String serviceDescription) {
        this.serviceDescription = serviceDescription;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }

    public Date getUpcomingServiceDate() {
        return upcomingServiceDate;
    }

    public void setUpcomingServiceDate(Date upcomingServiceDate) {
        this.upcomingServiceDate = upcomingServiceDate;
    }

    public String getServiceEngineerName() {
        return serviceEngineerName;
    }

    public void setServiceEngineerName(String serviceEngineerName) {
        this.serviceEngineerName = serviceEngineerName;
    }

    public ServiceCar getServiceCar() {
        return serviceCar;
    }

    public void setServiceCar(ServiceCar serviceCar) {
        this.serviceCar = serviceCar;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
