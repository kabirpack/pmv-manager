package com.app.pmvmanager.servicecar;

import com.app.pmvmanager.serviceticket.ServiceTicket;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "service_car")
public class ServiceCar {
    @Id
    private long plateNo;
    private String carModel;
    private String manufacturingYear;
    @Temporal(TemporalType.DATE)
    private Date upcomingServiceDate;
    private int driverId;


    @OneToMany
    List<ServiceTicket> serviceTicketList = new ArrayList<>();

    public ServiceCar() {
    }

    public ServiceCar(long plateNo, String carModel, String manufacturingYear, Date upcomingServiceDate, int driverId) {
        this.plateNo = plateNo;
        this.carModel = carModel;
        this.manufacturingYear = manufacturingYear;
        this.upcomingServiceDate = upcomingServiceDate;
        this.driverId = driverId;
    }

    public long getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(long plateNo) {
        this.plateNo = plateNo;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getManufacturingYear() {
        return manufacturingYear;
    }

    public void setManufacturingYear(String manufacturingYear) {
        this.manufacturingYear = manufacturingYear;
    }

    public Date getUpcomingServiceDate() {
        return upcomingServiceDate;
    }

    public void setUpcomingServiceDate(Date upcomingServiceDate) {
        this.upcomingServiceDate = upcomingServiceDate;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
