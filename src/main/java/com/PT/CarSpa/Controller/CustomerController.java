package com.PT.CarSpa.Controller;

import com.PT.CarSpa.Entity.CustomerEntity;
import com.PT.CarSpa.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class CustomerController
{
    @Autowired
    private CustomerService csr;

    @PostMapping("/addcar")
    public String saveCar(@RequestBody CustomerEntity cnt)
    {
        System.out.println("OBJECT: " + cnt);
        System.out.println("VNUM: " + cnt.getvNum());

        return csr.saveCar(cnt);
    }

}
