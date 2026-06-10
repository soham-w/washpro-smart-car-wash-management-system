package com.PT.CarSpa.Repository;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerComplaintRepository extends JpaRepository<CustomerComplaintEntity, String>
{

    CustomerComplaintEntity findByvNum(String vNum);
}
