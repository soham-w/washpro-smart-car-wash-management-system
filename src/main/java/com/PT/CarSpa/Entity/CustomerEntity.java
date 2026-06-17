package com.PT.CarSpa.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name = "customer")
public class CustomerEntity
{
    @Id
    @Column(name = "Vehicle_Number")
    private String vNum;

    @Column(name = "Vehicle_Location")
    private String vLocation;

    @Column(name = "Customer_Contact")
    private String custContact;

    @Column(name = "First_Washinh_Date")
    private LocalDate fristwashingdate;

    @Column(name = "Flat_Number")
    private String flatNum;

    @Column(name = "Washing_Type")
    private String washingType;



    @Column(name = "Amount")
    private String amount;

    public LocalDate getFristwashingdate() {
        return fristwashingdate;
    }

    public void setFristwashingdate(LocalDate fristwashingdate) {
        this.fristwashingdate = fristwashingdate;
    }

    public CustomerEntity() {}

    public String getvNum()
    {
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

    public String getCustContact() {
        return custContact;
    }

    public void setCustContact(String custContact) {
        this.custContact = custContact;
    }

    public String getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(String flatNum) {
        this.flatNum = flatNum;
    }

    public String getWashingType() {
        return washingType;
    }

    public void setWashingType(String washingType) {
        this.washingType = washingType;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}


