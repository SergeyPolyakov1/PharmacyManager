package com.pharmacymanager.pharmacy.controller;


import com.pharmacymanager.pharmacy.model.Pharmacy;
import com.pharmacymanager.pharmacy.model.Shipment;
import com.pharmacymanager.pharmacy.model.ShipmentModel;
import com.pharmacymanager.pharmacy.model.Vendor;
import com.pharmacymanager.pharmacy.repository.PharmacyRepository;
import com.pharmacymanager.pharmacy.repository.ShipmentRepository;
import com.pharmacymanager.pharmacy.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@Controller
public class PharmacyController {

    @Autowired
    private PharmacyRepository pharmacyRepository;
    @Autowired
    private VendorRepository vendorRepository;
    @Autowired
    private ShipmentRepository shipmentRepository;

    @GetMapping("/pharmacies")
    public String getPharmacies(Model model){
        List<Pharmacy> pharmacyList = pharmacyRepository.findAll();
        model.addAttribute("pharmacies",pharmacyList);
        return "showPharmacies";
    }

    @GetMapping("/pharmacies/{id}")
    public String showPharmacy(@PathVariable("id") Long id, Model model){

        Pharmacy pharmacy = pharmacyRepository.getOne(id);
        model.addAttribute("pharmacy",pharmacy);
        return "showPharmacy";
}

    @GetMapping("/newpharmacy")
    private String newPharmacy(@ModelAttribute("newPharmacy") Pharmacy pharmacy){
        return "newPharmacy";
    }

    @PostMapping("/pharmacies")
    public String createPharmacy(@ModelAttribute("newPharmacy") Pharmacy pharmacy){
        pharmacyRepository.save(pharmacy);
        return "redirect:/pharmacies";
    }

    @GetMapping("vendors")
    public String showVendors(Model model){
        List<Vendor> vendorList = vendorRepository.findAll();
        model.addAttribute("vendors",vendorList);
        return "showVendors";
    }

    @GetMapping("/vendors/{id}")
    public String getVendor(@PathVariable("id") Long id ,Model model){
        Vendor vendor = new Vendor();
        vendor = vendorRepository.getOne(id);
        model.addAttribute("vendor",vendor);
        return "showVendor";

    }

    @GetMapping("/newvendor")
    public String newVendor(@ModelAttribute("newVendor") Vendor vendor){
        return "newVendor";
    }

    @PostMapping("/vendors")
    public String createVendor(@ModelAttribute("newVendor") Vendor vendor){
        vendorRepository.save(vendor);
        return "redirect:/vendors";
    }
    @GetMapping("/vendors/{id}/edit")
    public String editVendor(Model model,@PathVariable("id") Long id){
        model.addAttribute("vendor",vendorRepository.getOne(id));
        return "editVendor";
    }

    @PutMapping ("/vendors/{id}")
    public String updateVendor(@ModelAttribute("vendor") Vendor vendor,@PathVariable Long id){

        Vendor vendorForUpdate = vendorRepository.getOne(id);
        vendorForUpdate.setAddress(vendor.getAddress());
        vendorForUpdate.setPhone(vendor.getPhone());
        vendorForUpdate.setTitle(vendor.getTitle());
        vendorRepository.save(vendorForUpdate);
        return "redirect:/vendors";
    }


    @GetMapping("/pharmacies/{id}/edit")
    public String editPharmacy(Model model,@PathVariable("id") Long id){

        model.addAttribute("pharmacy", pharmacyRepository.getOne(id));
        return "editPharmacy";
    }

    @PutMapping ("/pharmacies/{id}")
    public String updatePharmacy(@ModelAttribute("pharmacy") Pharmacy pharmacy,@PathVariable Long id){


      Pharmacy pharmacyForUpdate = pharmacyRepository.getOne(id);
      pharmacyForUpdate.setAddress(pharmacy.getAddress());
      pharmacyForUpdate.setPhone(pharmacy.getPhone());
      pharmacyForUpdate.setTitle(pharmacy.getTitle());
      pharmacyRepository.save(pharmacyForUpdate);
        return "redirect:/pharmacies";
    }

    @GetMapping("/pharmacies/{id}/newshipment")
    public String newShipment(@ModelAttribute("newShipment") Shipment shipment,@PathVariable Long id,Model model){

        model.addAttribute("pharmacy",pharmacyRepository.getOne(id));
        return "newShipment";
}


    @PostMapping("/addshipment")
    public String addShipment(@ModelAttribute("newShipment") ShipmentModel shipment){
        Shipment shipmentForSave = new Shipment();
        shipmentForSave.setExpirationDate(shipment.getExpirationDate());
        shipmentForSave.setShipmentDate(shipment.getShipmentDate());
        shipmentForSave.setMedicineQuantity(shipment.getMedicineQuantity());
        shipmentForSave.setPhone(shipment.getPhone());
        shipmentForSave.setVendor(shipment.getVendor());
        shipmentRepository.save(shipmentForSave);
        return "redirect:/pharmacies";
    }
}
