package com.land.hexagonal.applicatoin.ports.in;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;

public interface UpdateCustomerInputPort {

    void update(CustomerDomain customerDomain, String zipCode);
}
