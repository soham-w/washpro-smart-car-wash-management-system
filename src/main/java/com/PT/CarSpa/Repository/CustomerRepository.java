package com.PT.CarSpa.Repository;

import com.PT.CarSpa.Entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity , String>
{



}
