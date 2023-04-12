package com.app.pmvmanager.serviceticket;

import com.app.pmvmanager.servicecar.ServiceCar;
import com.app.pmvmanager.servicecar.ServiceCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ServiceTicketService {

    @Autowired
    ServiceTicketRepository serviceTicketRepository;
    @Autowired
    ServiceCarRepository serviceCarRepository;

    public ServiceTicket addServiceTicket(ServiceTicketRequestDto serviceTicketReq) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String upcomingServiceDateStr = serviceTicketReq.getUpcomingServiceDate();
        String lastServiceDateStr = serviceTicketReq.getLastServiceDate();
        Date upcomingServiceDate = formatter.parse(upcomingServiceDateStr);
        Date lastServiceDate = formatter.parse(lastServiceDateStr);
        ServiceTicket ticket = new ServiceTicket(serviceTicketReq.getLastServiceMileage(),
                lastServiceDate, serviceTicketReq.getServiceDescription(),
                serviceTicketReq.getServiceCost(),
                upcomingServiceDate);
        long pNo = serviceTicketReq.getServiceCarPlateNo();
        ServiceCar carToService = serviceCarRepository.findByPlateNo(pNo);
        ticket.setServiceCar(carToService);
        ticket.setServiceEngineerName(serviceTicketReq.getServiceEngineerName());
        return serviceTicketRepository.save(ticket);
    }

    public List<ServiceTicket> getUpcomingServiceTicketByDriverId(int driverId) {
        Date date = new Date();
        List<ServiceTicket> result = serviceTicketRepository.findUpcomingServiceTicketByDriverId(driverId, date);
        return result;
    }

    public List<ServiceTicket> getServiceTicketHistoryByDriverId(int driverId) {
        Date date = new Date();
        List<ServiceTicket> result = serviceTicketRepository.findServiceTicketHistoryByDriverId(driverId, date);
        return result;
    }

}
