package com.land.hexagonal.adapters.out;

import com.land.hexagonal.adapters.out.mapper.CustomerMapper;
import com.land.hexagonal.adapters.out.repository.CustomerRepository;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.out.UpdateCustomerOutputPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    public UpdateCustomerAdapter(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public void update(CustomerDomain customerDomain) {
        var customerEntity =  customerMapper.toCustomerEntity(customerDomain);
        customerRepository.save(customerEntity);
    }
}
