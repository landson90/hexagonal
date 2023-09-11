package com.land.hexagonal.adapters.out;

import com.land.hexagonal.adapters.out.mapper.CustomerMapper;
import com.land.hexagonal.adapters.out.repository.CustomerRepository;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class FindCustomerIdAdapter implements FindCustomerByIdOutputPort {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public FindCustomerIdAdapter(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public Optional<CustomerDomain> find(String id) {
        var customerEntity = this.customerRepository.findById(id);
        return customerEntity.map(m -> customerMapper.toCustomerDomain(m));
    }
}
