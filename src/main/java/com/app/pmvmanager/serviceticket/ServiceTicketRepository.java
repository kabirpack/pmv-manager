package com.app.pmvmanager.serviceticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.Date;

import java.util.List;

@RepositoryRestResource
public interface ServiceTicketRepository extends JpaRepository<ServiceTicket, Integer> {

    @Query("select s from ServiceTicket s  join s.serviceCar c where c.driverId = :driverId and s.upcomingServiceDate >= :currentDate")
    List<ServiceTicket> findUpcomingServiceTicketByDriverId(@Param("driverId") int driverId,
                                                            @Param("currentDate") Date currentDate);

    @Query("select s from ServiceTicket s  join s.serviceCar c where c.driverId = :driverId and s.upcomingServiceDate <= :currentDate")
    List<ServiceTicket> findServiceTicketHistoryByDriverId(@Param("driverId") int driverId,
                                                            @Param("currentDate") Date currentDate);

}

