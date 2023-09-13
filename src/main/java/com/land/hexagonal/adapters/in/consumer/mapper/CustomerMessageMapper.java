package com.land.hexagonal.adapters.in.consumer.mapper;


import com.land.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.land.hexagonal.applicatoin.core.domain.CustomerDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMessageMapper {

    @Mapping(target = "tp-cpf-validated", ignore = true)
    CustomerDomain toCostomer(CustomerMessage customerMessage);
}
