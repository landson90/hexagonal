package com.land.hexagonal.config;

import com.land.hexagonal.adapters.out.DeleteCustomerAdapter;
import com.land.hexagonal.applicatoin.core.usecase.DeleteCustomerUseCase;
import com.land.hexagonal.applicatoin.ports.in.FindCustomerByInputPort;
import com.land.hexagonal.applicatoin.ports.out.DeleteCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
public class DeleteCustomerConfig {


    @Bean
    public DeleteCustomerUseCase deleteCustomerUseCase(
            FindCustomerByInputPort customerByInputPort,
            DeleteCustomerAdapter deleteCustomerAdapter
    ) {
        return new DeleteCustomerUseCase(customerByInputPort, deleteCustomerAdapter);
    }
}
