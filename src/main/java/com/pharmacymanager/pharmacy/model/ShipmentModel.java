package com.pharmacymanager.pharmacy.model;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


public class ShipmentModel {


    private Long id;


    private String medicineTitle;



    private LocalDate shipmentDate;



    private LocalDate expirationDate;

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public LocalDate getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(LocalDate shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }


    private Long medicineQuantity;


    private String phone;


    private Pharmacy pharmacy;


    private Vendor vendor;
    public ShipmentModel(){}
    public ShipmentModel(Long id, String medicineTitle, LocalDate shipmentDate, LocalDate expirationDate, Long medicineQuantity, String phone) {
        this.id = id;
        this.medicineTitle = medicineTitle;
        this.shipmentDate = shipmentDate;
        this.expirationDate = expirationDate;
        this.medicineQuantity = medicineQuantity;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineTitle() {
        return medicineTitle;
    }

    public void setMedicineTitle(String medicineTitle) {
        this.medicineTitle = medicineTitle;
    }



    public Long getMedicineQuantity() {
        return medicineQuantity;
    }

    public void setMedicineQuantity(Long medicineQuantity) {
        this.medicineQuantity = medicineQuantity;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

