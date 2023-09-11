package com.land.hexagonal.adapters.out;

import com.land.hexagonal.adapters.out.mapper.CustomerMapper;
import com.land.hexagonal.adapters.out.repository.CustomerRepository;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.out.InsertCustomerDomainOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InsertCustomerAdapter implements InsertCustomerDomainOutputPort {

    private final CustomerRepository customerRepository;
    private  final CustomerMapper customerMapper;

    @Autowired
    public InsertCustomerAdapter(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public void insert(CustomerDomain customerDomain) {
        var addressEntity = this.customerMapper.toCustomerEntity(customerDomain);
        customerRepository.save(addressEntity);
    }
}
