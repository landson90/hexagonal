package com.land.hexagonal.adapters.out;

import com.land.hexagonal.adapters.out.repository.CustomerRepository;
import com.land.hexagonal.applicatoin.ports.out.DeleteCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteCustomerAdapter implements DeleteCustomerOutputPort {

    private CustomerRepository customerRepository;

    @Autowired
    public DeleteCustomerAdapter(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public void delete(String id) {
        customerRepository.deleteById(id);
    }
}
