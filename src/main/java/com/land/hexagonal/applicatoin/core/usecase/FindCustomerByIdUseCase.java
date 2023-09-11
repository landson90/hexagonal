package com.land.hexagonal.applicatoin.core.usecase;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.in.FindCustomerByInputPort;
import com.land.hexagonal.applicatoin.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;


    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public CustomerDomain find(String id ) {
        return this.findCustomerByIdOutputPort
                .find(id)
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}
