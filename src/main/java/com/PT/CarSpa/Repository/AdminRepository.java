package com.PT.CarSpa.Repository;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<CustomerEntity , String>
{
    CustomerEntity findByvNum(String vNum);


}
