package com.land.hexagonal.applicatoin.ports.out;

import com.land.hexagonal.applicatoin.core.domain.AddressDomain;

public interface FindAddressByZipCodeOutputPort {

    AddressDomain find(String zipCode);
}
