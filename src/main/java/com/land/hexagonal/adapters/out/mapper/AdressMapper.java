package com.land.hexagonal.adapters.out.mapper;


import com.land.hexagonal.adapters.out.client.response.AdressResponseClient;
import com.land.hexagonal.applicatoin.core.domain.AddressDomain;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface AdressMapper {


    AddressDomain toAdress(AdressResponseClient adressResponseClient);
}
