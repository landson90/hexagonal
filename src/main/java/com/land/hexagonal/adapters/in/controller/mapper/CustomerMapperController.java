package com.land.hexagonal.adapters.in.controller.mapper;


import com.land.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.land.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper( componentModel = "spring")
public interface CustomerMapperController {


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "isValidCpf", ignore = true)
    CustomerDomain toCustomerDomain(CustomerRequest customerRequest);

    CustomerEntity toCustomerEntity(CustomerDomain customerDomain);
}
