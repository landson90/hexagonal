package com.land.hexagonal.applicatoin.ports.out;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;

public interface InsertCustomerDomainOutputPort {

    void insert(CustomerDomain customerDomain);
}
