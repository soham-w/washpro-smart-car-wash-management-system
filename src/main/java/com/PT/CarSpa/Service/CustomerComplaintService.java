package com.PT.CarSpa.Service;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Repository.CustomerComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerComplaintService
{

    @Autowired
    private CustomerComplaintRepository ccr;

    public String saveComplaint(CustomerComplaintEntity cce)
    {


        ccr.save(cce);

        return "complaint submit successfully..!";
    }
}
