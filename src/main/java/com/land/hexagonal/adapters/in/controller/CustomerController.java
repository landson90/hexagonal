package com.land.hexagonal.adapters.in.controller;


import com.land.hexagonal.adapters.in.controller.mapper.CustomerMapperController;
import com.land.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.land.hexagonal.applicatoin.ports.in.InsterCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private InsterCustomerInputPort insterCustomerInputPort;
    private CustomerMapperController customerMapperController;

    @Autowired
    public CustomerController(InsterCustomerInputPort insterCustomerInputPort, CustomerMapperController customerMapperController) {
        this.insterCustomerInputPort = insterCustomerInputPort;
        this.customerMapperController = customerMapperController;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody CustomerRequest customerRequest) {
        var custormeDomain = this.customerMapperController.toCustomerDomain(customerRequest);
        this.insterCustomerInputPort.insert(custormeDomain, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
