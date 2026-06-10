package com.PT.CarSpa.Service;

import com.PT.CarSpa.Entity.CustomerEntity;
import com.PT.CarSpa.Repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService
{

    @Autowired
    private CustomerRepository crp;

    public String saveCar(CustomerEntity cnt)
    {
        try
        {
            String type = cnt.getWashingType().trim();

            if(type.equalsIgnoreCase("Daily"))
            {
                cnt.setAmount("1000");
            }
            else if(type.equalsIgnoreCase("Alternative"))
            {
                cnt.setAmount("700");
            }
            else if(type.equalsIgnoreCase("2 times in week"))
            {
                cnt.setAmount("500");
            }
            else if(type.equalsIgnoreCase("Today"))
            {
                cnt.setAmount("150");
            }
            else
            {
                cnt.setAmount("0");
            }

            System.out.println("Type = " + type);
            System.out.println("Amount = " + cnt.getAmount());

            crp.save(cnt);

            return "Enter Successfully...!";
        }
        catch(Exception e)
        {
            e.printStackTrace();
            return "Error";
        }
    }

}
