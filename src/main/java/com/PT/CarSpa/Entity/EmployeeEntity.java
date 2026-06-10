package com.PT.CarSpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "employee")
public class EmployeeEntity
{

    @Id
    @Column(name = "Emp_Id")
    private int empid;

    @Column(name = "Emp_Name")
    private String empname;

    @Column(name = "Emp_Joining_Date")
    private LocalDate empjoiningdate;

    @Column(name = "Emp_Salary")
    private long empsalary;

    @Column(name = "Emp_Contact")
    private long empcontact;

    public long getEmpcontact() {
        return empcontact;
    }

    public void setEmpcontact(long empcontact) {
        this.empcontact = empcontact;
    }

    @Column(name = "Emp_Work_Location")
    private String empworklocation;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public LocalDate getEmpjoiningdate() {
        return empjoiningdate;
    }

    public void setEmpjoiningdate(LocalDate empjoiningdate) {
        this.empjoiningdate = empjoiningdate;
    }

    public long getEmpsalary() {
        return empsalary;
    }

    public void setEmpsalary(long empsalary) {
        this.empsalary = empsalary;
    }

    public String getEmpworklocation() {
        return empworklocation;
    }

    public void setEmpworklocation(String empworklocation) {
        this.empworklocation = empworklocation;
    }
}

