package com.esg.ecoprocure.controller;

import com.esg.ecoprocure.exception.RecordNotFoundException;
import com.esg.ecoprocure.model.Items;
import com.esg.ecoprocure.model.ItemsMerge;
import com.esg.ecoprocure.model.Supplier;
import com.esg.ecoprocure.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/procure")
public class EcoProcureController {

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers/{supplierId}")
    public List<ItemsMerge> findSupplier(@PathVariable("supplierId") long supplierId) throws RecordNotFoundException, IOException, InterruptedException {

        List<ItemsMerge> supplier =  supplierService.getBySupplierId(supplierId);

        if(!supplier.isEmpty()){
            return supplier;
        }
        else{
            throw new RecordNotFoundException();
        }
    }


    @GetMapping("/suppliers")
    public ResponseEntity<List<Supplier>> getAllSuppliers() {
        return new ResponseEntity<>(supplierService.getAll(), HttpStatus.OK);
    }
}

