package com.land.hexagonal.config;

import com.land.hexagonal.adapters.out.FindAdressByZipCodeAdapater;
import com.land.hexagonal.adapters.out.FindCustomerIdAdapter;
import com.land.hexagonal.adapters.out.UpdateCustomerAdapter;
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
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerIdAdapter findCustomerIdAdapter,
                                                       FindAdressByZipCodeAdapater findAdressByZipCodeAdapater,
                                                       UpdateCustomerAdapter updateCustomerAdapter) {
        return new UpdateCustomerUseCase(
                findCustomerIdAdapter,
                findAdressByZipCodeAdapater,
                updateCustomerAdapter
        );
    }
}
