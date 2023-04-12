package com.app.pmvmanager.serviceticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
public class ServiceTicketController {

    @Autowired
    ServiceTicketService serviceTicketService;

    @PostMapping("/addServiceTicket")
    public ResponseEntity<ServiceTicket> addServiceTicket(@RequestBody ServiceTicketRequestDto serviceTicketReq) throws ParseException {
        return new ResponseEntity<>(serviceTicketService.addServiceTicket(serviceTicketReq), HttpStatus.OK);
    }

    @GetMapping("/getUpcomingServiceTicketByDriver")
    public ResponseEntity<List<ServiceTicket>> getUpcomingServiceTicketByDriver(
            @RequestParam int driverId
    ) {
        return new ResponseEntity<>(serviceTicketService.getUpcomingServiceTicketByDriverId(driverId), HttpStatus.OK);
    }

    @GetMapping("/getServiceTicketHistoryByDriver")
    public ResponseEntity<List<ServiceTicket>> getServiceTicketHistoryByDriver(
            @RequestParam int driverId
    ) {
        return new ResponseEntity<>(serviceTicketService.getServiceTicketHistoryByDriverId(driverId), HttpStatus.OK);
    }


}
