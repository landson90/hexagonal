package com.land.hexagonal.applicatoin.core.usecase;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.in.InsterCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import com.land.hexagonal.applicatoin.ports.out.InsertCustomerDomainOutputPort;

public class InsertCustomerUseCase implements InsterCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerDomainOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerDomainOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(CustomerDomain customerDomain, String zipCode) {
        var address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customerDomain.setAddress(address);
        this.insertCustomerOutputPort.insert(customerDomain);

    }


}
