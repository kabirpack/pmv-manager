package com.app.pmvmanager.servicecar;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@RepositoryRestResource
@Transactional
public interface ServiceCarRepository extends JpaRepository<ServiceCar, Long> {

    @Query("select c from ServiceCar c where c.upcomingServiceDate >=  :currentDate")
    List<ServiceCar> getAllUpcomingServiceCars (@Param("currentDate") Date currentDate);

    @Query("select c from ServiceCar c where c.plateNo = :plateNo")
    @Transactional(readOnly = true)
    ServiceCar findByPlateNo(@Param("plateNo") long plateNo);

    @Query( value = "select c.plate_no as plateNo, s.last_service_mileage as lastServiceMileage, sum(s.service_cost) as serviceCost, max(s.last_service_date) as lastServiceDate, count(s.service_car_plate_no) as freq from service_car c join service_ticket s on c.plate_no = s.service_car_plate_no\n" +
            "where s.created_date between :fromDate and :toDate group by c.plate_no, lastServiceMileage order by freq desc;\n", nativeQuery = true)
    List<ServiceCarManagerViewDto> findCarsByServiceCost(@Param("fromDate") Date fromDate,
                                      @Param("toDate") Date toDate);

}
