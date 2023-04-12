package com.app.pmvmanager.servicecar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceCarService {

    @Autowired
    ServiceCarRepository serviceCarRepository;

    public ServiceCar addServiceCar(ServiceCar car) {
        return serviceCarRepository.save(car);
    }

    public List<ServiceCar> getUpcomingServiceCars() {
        Date today = new Date();
        List<ServiceCar> upcomingServiceCars = serviceCarRepository.getAllUpcomingServiceCars(today);
        return upcomingServiceCars;
    }

    public List<ServiceCarManagerViewDto> getServiceCarsByServiceCost(String fromDateStr, String toDateStr) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd" +
                "");
        Date fromDate = formatter.parse(fromDateStr);
        Date toDate = formatter.parse(toDateStr);

        List<ServiceCarManagerViewDto> result = serviceCarRepository.findCarsByServiceCost(fromDate, toDate);


        return result;
    }
}
