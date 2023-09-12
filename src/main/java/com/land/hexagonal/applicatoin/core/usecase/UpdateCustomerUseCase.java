package com.land.hexagonal.applicatoin.core.usecase;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.in.UpdateCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import com.land.hexagonal.applicatoin.ports.out.FindCustomerByIdOutputPort;
import com.land.hexagonal.applicatoin.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;
    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;


    public UpdateCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort, FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }


    @Override
    public void update(CustomerDomain customerDomain, String zipCode) {
        findCustomerByIdOutputPort.find(zipCode);
        var edrresss = findAddressByZipCodeOutputPort.find(zipCode);
         customerDomain.setAddress(edrresss);
         updateCustomerOutputPort.update(customerDomain);

    }
}
