package com.PT.CarSpa.Controller;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Service.CustomerComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerComplaintController
{

    @Autowired
    private CustomerComplaintService ccs;

    @PostMapping("/complaint")
    public String customerComplaint(@RequestBody CustomerComplaintEntity cce)
    {
        return ccs.saveComplaint(cce);
    }
}
