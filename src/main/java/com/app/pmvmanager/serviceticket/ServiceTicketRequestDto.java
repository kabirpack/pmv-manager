package com.app.pmvmanager.serviceticket;

public class ServiceTicketRequestDto {

    private int lastServiceMileage;
    private String lastServiceDate;
    private String serviceDescription;
    private Double serviceCost;
    private String upcomingServiceDate;
    private String serviceEngineerName;
    private long serviceCarPlateNo;

    public int getLastServiceMileage() {
        return lastServiceMileage;
    }

    public void setLastServiceMileage(int lastServiceMileage) {
        this.lastServiceMileage = lastServiceMileage;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
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

    public String getUpcomingServiceDate() {
        return upcomingServiceDate;
    }

    public void setUpcomingServiceDate(String upcomingServiceDate) {
        this.upcomingServiceDate = upcomingServiceDate;
    }

    public String getServiceEngineerName() {
        return serviceEngineerName;
    }

    public void setServiceEngineerName(String serviceEngineerName) {
        this.serviceEngineerName = serviceEngineerName;
    }

    public long getServiceCarPlateNo() {
        return serviceCarPlateNo;
    }

    public void setServiceCarPlateNo(long serviceCarPlateNo) {
        this.serviceCarPlateNo = serviceCarPlateNo;
    }
}
