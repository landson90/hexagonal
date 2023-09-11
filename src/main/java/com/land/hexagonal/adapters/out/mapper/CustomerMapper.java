package com.land.hexagonal.adapters.out.mapper;


import com.land.hexagonal.adapters.out.repository.entity.CustomerEntity;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import org.mapstruct.Mapper;

@Mapper( componentModel = "spring")
public interface CustomerMapper {


    CustomerDomain toCustomerDomain(CustomerEntity customerEntity);

    CustomerEntity toCustomerEntity(CustomerDomain customerDomain);
}
