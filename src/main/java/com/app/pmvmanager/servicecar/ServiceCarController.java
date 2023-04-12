package com.app.pmvmanager.servicecar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class ServiceCarController {

    @Autowired
    ServiceCarService serviceCarService;

    @PostMapping("/addServiceCar")
    public ResponseEntity<ServiceCar> addServiceCar(@RequestBody ServiceCarRequestDto carRequest) throws ParseException {
        String upcomingServiceDateStr = carRequest.getUpcomingServiceDate();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date upcomingServiceDate = formatter.parse(upcomingServiceDateStr);
        ServiceCar car = new ServiceCar(carRequest.getPlateNo(),
                carRequest.getCarModel(), carRequest.getManufacturingYear(), upcomingServiceDate, carRequest.getDriverId());
        return new ResponseEntity<>(serviceCarService.addServiceCar(car), HttpStatus.OK);
    }

    @GetMapping("/getUpcomingServiceCars")
    public ResponseEntity<List<ServiceCar>> getUpcomingServiceCars() {
        return new ResponseEntity<>(serviceCarService.getUpcomingServiceCars(), HttpStatus.OK);
    }


    @GetMapping("/getCarsByServiceCost")
    public List<ServiceCarManagerViewDto> getCarsByServiceCost(
            @RequestParam String fromDate,
            @RequestParam String toDate
    ) throws ParseException {
        return serviceCarService.getServiceCarsByServiceCost(fromDate, toDate);
    }
}
