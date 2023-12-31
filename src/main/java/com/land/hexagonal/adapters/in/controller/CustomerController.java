package com.land.hexagonal.adapters.in.controller;


import com.land.hexagonal.adapters.in.controller.mapper.CustomerMapperController;
import com.land.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.land.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.land.hexagonal.applicatoin.ports.in.DeleteCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.in.FindCustomerByInputPort;
import com.land.hexagonal.applicatoin.ports.in.InsterCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private InsterCustomerInputPort insterCustomerInputPort;
    private CustomerMapperController customerMapperController;
    private FindCustomerByInputPort customerByInputPort;
    private UpdateCustomerInputPort updateCustomerInputPort;
    private DeleteCustomerInputPort deleteCustomerInputPort;
    @Autowired
    public CustomerController(InsterCustomerInputPort insterCustomerInputPort, CustomerMapperController customerMapperController, FindCustomerByInputPort customerByInputPort, UpdateCustomerInputPort updateCustomerInputPort, DeleteCustomerInputPort deleteCustomerInputPort) {
        this.insterCustomerInputPort = insterCustomerInputPort;
        this.customerMapperController = customerMapperController;
        this.customerByInputPort = customerByInputPort;
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.deleteCustomerInputPort = deleteCustomerInputPort;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Validated @RequestBody CustomerRequest customerRequest) {
        var custormeDomain = this.customerMapperController.toCustomerDomain(customerRequest);
        this.insterCustomerInputPort.insert(custormeDomain, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> findBy(@PathVariable("id") String id) {
        var custormeDomain = this.customerByInputPort.find(id);
        var response = this.customerMapperController.toCustomerResponse(custormeDomain);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> upate(@PathVariable("id") String id,
                                                  @Validated @RequestBody CustomerRequest customerRequest) {
        var custormeDomain = this.customerMapperController.toCustomerDomain(customerRequest);
        custormeDomain.setId(id);
        updateCustomerInputPort.update(custormeDomain, customerRequest.getZipCode());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        deleteCustomerInputPort.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
