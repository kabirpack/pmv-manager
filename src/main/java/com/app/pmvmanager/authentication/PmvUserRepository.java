package com.app.pmvmanager.authentication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PmvUserRepository extends JpaRepository<PmvUser, Integer> {


    PmvUser findByUserName(String userName);

    @Query(value="select u.user_id from pmv_user u where u.user_role = 'driver'", nativeQuery = true)
    int[] findDriverIds();
}
