package com.PT.CarSpa.Service;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Entity.CustomerEntity;
import com.PT.CarSpa.Entity.EmployeeEntity;
import com.PT.CarSpa.Repository.CustomerComplaintRepository;
import com.PT.CarSpa.Repository.CustomerRepository;
import com.PT.CarSpa.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService
{

    @Autowired
    private EmployeeRepository empr;

    @Autowired
    private CustomerRepository cstr;

    @Autowired
    CustomerComplaintRepository ccr;

    public String saveEntry(EmployeeEntity empe)
    {
        empr.save(empe);

        return "save Successfully...!";
    }

    public List<EmployeeEntity> getEmpData()
    {
        return empr.findAll();
    }

    public List<String> findvNumberByEmpLocation(String empLocation)
    {
        List<CustomerEntity> list = cstr.findAll();

        List<String> result = new ArrayList<>();

        for(CustomerEntity eObj : list)
        {
            if(empLocation.equalsIgnoreCase(eObj.getvLocation()))
            {
                result.add(eObj.getvNum());
            }
        }

        return result;
    }

    public List<String> findDailyTask(String empLocation)
    {
        List<CustomerEntity> list = cstr.findAll();
        List<String> result = new ArrayList<>();

        for(CustomerEntity eObj : list)
        {
            if(empLocation.equalsIgnoreCase(eObj.getvLocation()))
            {
                if(eObj.getWashingType().equalsIgnoreCase("Daily"))
                {
                    result.add(eObj.getvNum());
                }
                else if(eObj.getWashingType().equalsIgnoreCase("Alternative"))
                {
                    long days = ChronoUnit.DAYS.between(
                            eObj.getFristwashingdate(),
                            LocalDate.now()
                    );

                    if(days % 2 == 0)
                    {
                        result.add(eObj.getvNum());
                    }
                }
            }
        }
        return result;
    }

    public List<CustomerComplaintEntity> getAllComplaints(String vLocation)
    {
        List<CustomerComplaintEntity> list = ccr.findAll();
        List<CustomerComplaintEntity> filterlist = new ArrayList<>();

        for(CustomerComplaintEntity cceObj : list)
        {
            if(vLocation.equalsIgnoreCase(cceObj.getvLocation()))
            {
                filterlist.add(cceObj);
            }
        }

        return filterlist;
    }
}


