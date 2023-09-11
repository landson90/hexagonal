package com.land.hexagonal.adapters.out;

import com.land.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.land.hexagonal.adapters.out.mapper.AdressMapper;
import com.land.hexagonal.applicatoin.core.domain.AddressDomain;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAdressByZipCodeAdapater implements FindAddressByZipCodeOutputPort {

    private final FindAddressByZipCodeClient  findAddressByZipCodeClient;
    private final AdressMapper adressMapper;

    @Autowired
    public FindAdressByZipCodeAdapater(FindAddressByZipCodeClient findAddressByZipCodeClient, AdressMapper adressMapper) {
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.adressMapper = adressMapper;
    }


    @Override
    public AddressDomain find(String zipCode) {
        var adressReponseFienClient = this.findAddressByZipCodeClient.find(zipCode);
        var addressDomain = this.adressMapper.toAddress(adressReponseFienClient);
        return addressDomain;
    }
}
