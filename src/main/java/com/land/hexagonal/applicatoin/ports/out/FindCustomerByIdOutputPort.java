package com.land.hexagonal.applicatoin.ports.out;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<CustomerDomain> find(String id);

}
