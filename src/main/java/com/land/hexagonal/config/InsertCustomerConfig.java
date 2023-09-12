package com.land.hexagonal.config;


import com.land.hexagonal.applicatoin.core.usecase.InsertCustomerUseCase;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import com.land.hexagonal.applicatoin.ports.out.InsertCustomerDomainOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
            InsertCustomerDomainOutputPort insertCustomerOutputPort
    ) {
       return new InsertCustomerUseCase(findAddressByZipCodeOutputPort, insertCustomerOutputPort);
    }
}
