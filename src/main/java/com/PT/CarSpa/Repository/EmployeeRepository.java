package com.PT.CarSpa.Repository;

import com.PT.CarSpa.Entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity , Integer>
{


}
