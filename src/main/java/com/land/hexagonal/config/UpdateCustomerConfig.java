package com.land.hexagonal.config;

import com.land.hexagonal.applicatoin.core.usecase.UpdateCustomerUseCase;
import com.land.hexagonal.applicatoin.ports.out.FindAddressByZipCodeOutputPort;
import com.land.hexagonal.applicatoin.ports.out.FindCustomerByIdOutputPort;
import com.land.hexagonal.applicatoin.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class UpdateCustomerConfig {


    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort,
                                                       FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort,
                                                       UpdateCustomerOutputPort updateCustomerOutputPort) {
        return new UpdateCustomerUseCase(
                findCustomerByIdOutputPort,
                findAddressByZipCodeOutputPort,
                updateCustomerOutputPort
        );
    }
}
