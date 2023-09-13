package com.land.hexagonal.applicatoin.core.usecase;

import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import com.land.hexagonal.applicatoin.ports.in.InsterCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import com.land.hexagonal.applicatoin.ports.out.InsertCustomerDomainOutputPort;
import com.land.hexagonal.applicatoin.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsterCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;
    private final InsertCustomerDomainOutputPort insertCustomerOutputPort;
    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                 InsertCustomerDomainOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(CustomerDomain customerDomain, String zipCode) {
        var address = this.findAddressByZipCodeOutputPort.find(zipCode);
        customerDomain.setAddress(address);
        this.insertCustomerOutputPort.insert(customerDomain);
        this.sendCpfForValidationOutputPort.send(customerDomain.getCpf());
    }


}
