package com.app.pmvmanager.servicecar;

public class ServiceCarRequestDto {

    private long plateNo;
    private String carModel;
    private String manufacturingYear;
    private String upcomingServiceDate;
    private int driverId;

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

    public String getUpcomingServiceDate() {
        return upcomingServiceDate;
    }

    public void setUpcomingServiceDate(String upcomingServiceDate) {
        this.upcomingServiceDate = upcomingServiceDate;
    }

    public int getDriverId() {
        return driverId;
    }

    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
}
