package com.PT.CarSpa.Controller;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Entity.CustomerEntity;
import com.PT.CarSpa.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController
{
    @Autowired
    private AdminService ads;

    @PostMapping("/addvehicle")
    public ResponseEntity<String> saveCar(@RequestBody CustomerEntity cnt)
    {
        System.out.println("OBJECT: " + cnt);
        System.out.println("VNUM: " + cnt.getvNum());

        return ads.saveCar(cnt);
    }

    @GetMapping("/showallvehicle")
    public ResponseEntity<List<CustomerEntity>> showAll()
    {
        return ResponseEntity.ok(ads.showAll());
    }

    @GetMapping("/showvehiclebyvnumber/{vNum}")
    public ResponseEntity<CustomerEntity> findByvNum(@PathVariable String vNum)
    {
        CustomerEntity cObj = ads.getByvNum(vNum);

        if(cObj != null)
        {
            return ResponseEntity.ok(ads.getByvNum(vNum));
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }

    @GetMapping("/dailyvehiclecount")
    public ResponseEntity<List<Map<String,String>>> getCountDaily()
    {

        return ResponseEntity.ok(ads.countDailyVehicles());
    }

    @GetMapping("/totalincome")
    public ResponseEntity<String> getTotalIncome()
    {
        return ResponseEntity.ok("Total income : " + ads.totalIncome());
    }

    @GetMapping("/totalincomebylocation/{vLocation}")
    public ResponseEntity<String> getTotalIncomeByLocation(@PathVariable String vLocation)
    {
        return ResponseEntity.ok(vLocation + " : "+ads.totalIncomeByLocation(vLocation));
    }

    @GetMapping("/showcustomercomplaint")
    public List<CustomerComplaintEntity> showAllComplents()
    {
        return ads.getComplaints();
    }

    @GetMapping("/showcustomercomplaintbyvnumber/{vNum}")
    public ResponseEntity<?> showComplentsByVNumber(@PathVariable String vNum)
    {
        CustomerComplaintEntity complaint = ads.getComplaintsVNumber(vNum);

        if (complaint == null)
        {
            return ResponseEntity.status(404).body("No complaint found for vehicle number: " + vNum);
        }

        return ResponseEntity.ok(complaint);
    }
}