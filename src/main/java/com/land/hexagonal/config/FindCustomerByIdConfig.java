package com.land.hexagonal.config;

import com.land.hexagonal.adapters.out.FindCustomerIdAdapter;
import com.land.hexagonal.applicatoin.core.usecase.FindCustomerByIdUseCase;
import com.land.hexagonal.applicatoin.ports.out.FindCustomerByIdOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(FindCustomerIdAdapter findCustomerIdAdapter) {
        return new FindCustomerByIdUseCase(findCustomerIdAdapter);
    }
}
