package com.PT.CarSpa.Service;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Entity.CustomerEntity;
import com.PT.CarSpa.Repository.AdminRepository;
import com.PT.CarSpa.Repository.CustomerComplaintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Autowired
    private  AdminRepository adr;

    @Autowired
    private CustomerComplaintRepository ccr;

    public ResponseEntity<String>saveCar(CustomerEntity cnt) {
        try {
            String type = cnt.getWashingType().trim();

            if (type.equalsIgnoreCase("Daily")) {
                cnt.setAmount("1000");
            } else if (type.equalsIgnoreCase("Alternative")) {
                cnt.setAmount("700");
            } else if (type.equalsIgnoreCase("2 times in week")) {
                cnt.setAmount("500");
            } else if (type.equalsIgnoreCase("Today")) {
                cnt.setAmount("150");
            } else {
                cnt.setAmount("0");
            }

            System.out.println("Type = " + type);
            System.out.println("Amount = " + cnt.getAmount());

            adr.save(cnt);

            return ResponseEntity.status(201).body("Vehicle Added Successfully...!");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("ERROR Generate...!");
        }
    }

    public List<CustomerEntity> showAll()
    {
        return adr.findAll();
    }

    public CustomerEntity getByvNum(String vNum) {
        return adr.findByvNum(vNum);
    }

    public List<Map<String, String>> countDailyVehicles()
    {
        List<CustomerEntity> list = adr.findAll();

        List<Map<String, String>> result = new ArrayList<>();

        for (CustomerEntity cObj : list)
        {
            if (cObj.getWashingType().equalsIgnoreCase("Daily"))
            {
                Map<String, String> map = new HashMap<>();

                map.put("vNum", cObj.getvNum());
                map.put("vLocation", cObj.getvLocation());

                result.add(map);
            }
        }

        return result;
    }

    public long totalIncome() {

        List<CustomerEntity> list = adr.findAll();

        long lTotal = 0;

        for (CustomerEntity cobj : list) {
            String amt = cobj.getAmount();

            if (amt != null && !amt.trim().isEmpty()) {
                lTotal = lTotal + Long.parseLong(amt);
            }
        }

        return lTotal;
    }

    public long totalIncomeByLocation(String vLocation)
    {
        List<CustomerEntity> list = adr.findAll();

        long lTotal = 0;

        for (CustomerEntity cObj : list) {
            if (cObj.getvLocation().equalsIgnoreCase(vLocation)) {
                String amt = cObj.getAmount();

                if (amt != null && !amt.trim().isEmpty()) {
                    lTotal = lTotal + Long.parseLong(amt);
                }
            }
        }

        return lTotal;
    }


    public List<CustomerComplaintEntity> getComplaints()
    {
        return ccr.findAll();
    }


    public CustomerComplaintEntity getComplaintsVNumber(String vNum)
    {
        return ccr.findByvNum(vNum);
    }
}

