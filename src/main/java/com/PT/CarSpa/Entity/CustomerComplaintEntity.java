package com.PT.CarSpa.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customercomplaint")
public class CustomerComplaintEntity
{

    @Column(name = "Vehicle_Number")
    @Id
    private String vNum;

    @Column(name = "Vehicle_Location")
    private String vLocation;

    @Column(name = "Complaint")
    private String vComplaint;



    public String getvNum() {
        return vNum;
    }

    public void setvNum(String vNum) {
        this.vNum = vNum;
    }

    public String getvLocation() {
        return vLocation;
    }

    public void setvLocation(String vLocation) {
        this.vLocation = vLocation;
    }

    public String getvComplaint() {
        return vComplaint;
    }

    public void setvComplaint(String vComplaint) {
        this.vComplaint = vComplaint;
    }


}
