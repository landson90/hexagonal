package com.land.hexagonal.config;


import com.land.hexagonal.adapters.out.FindAdressByZipCodeAdapater;
import com.land.hexagonal.adapters.out.InsertCustomerAdapter;
import com.land.hexagonal.adapters.out.SendCpfForValidationAdapter;
import com.land.hexagonal.applicatoin.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InsertCustomerConfig {

    @Bean
    public InsertCustomerUseCase insertCustomerUseCase(
            FindAdressByZipCodeAdapater findAdressByZipCodeAdapater,
            InsertCustomerAdapter insertCustomerAdapter,
            SendCpfForValidationAdapter sendCpfForValidationAdapter

    ) {
       return new InsertCustomerUseCase(findAdressByZipCodeAdapater, insertCustomerAdapter, sendCpfForValidationAdapter);
    }
}
