package com.PT.CarSpa.Controller;

import com.PT.CarSpa.Entity.CustomerComplaintEntity;
import com.PT.CarSpa.Entity.EmployeeEntity;
import com.PT.CarSpa.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{

    @Autowired
    private EmployeeService emps;

    @PostMapping("/enteremployee")
    public String saveEmp(@RequestBody EmployeeEntity empe)
    {
        emps.saveEntry(empe);
        return "Employee Add successfully....!";
    }

    @GetMapping("/employeedata")
    public List<EmployeeEntity> empData()
    {
        return emps.getEmpData();
    }

    @GetMapping("/vnumberusingemplyeelocation/{empLocation}")
    public ResponseEntity<?> getvNumberUsingEmpLocation(@PathVariable String empLocation)
    {
        List<String> list = emps.findvNumberByEmpLocation(empLocation);

        if(list.isEmpty())
        {
            return ResponseEntity.status(404).body("Enter location is wrong : "+empLocation);
        }

        return ResponseEntity.ok(list);
    }

   @GetMapping("/todaystask/{empLocation}")
   public List<String> getTodaysTask(@PathVariable String empLocation)
   {
       return emps.findDailyTask(empLocation);
   }

   @GetMapping("/comaplaints/{empLocation}")
    public ResponseEntity<?> showAllComplaints(@PathVariable String empLocation)
   {
       List<CustomerComplaintEntity> complaints = emps.getAllComplaints(empLocation);

       if(complaints.isEmpty())
       {
           return ResponseEntity.status(404).body("No complaint found for vehicle Location: " + empLocation);
       }

       return ResponseEntity.ok(complaints);
   }
}
