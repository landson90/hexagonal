package com.land.hexagonal.applicatoin.ports.in;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;

public interface InsterCustomerInputPort {


    void insert(CustomerDomain customerDomain, String zipCode);
}
