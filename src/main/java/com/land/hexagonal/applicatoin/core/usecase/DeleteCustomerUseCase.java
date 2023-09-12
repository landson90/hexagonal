package com.land.hexagonal.applicatoin.core.usecase;

import com.land.hexagonal.applicatoin.ports.in.DeleteCustomerInputPort;
import com.land.hexagonal.applicatoin.ports.in.FindCustomerByInputPort;
import com.land.hexagonal.applicatoin.ports.out.DeleteCustomerOutputPort;

public class DeleteCustomerUseCase implements DeleteCustomerInputPort {

    private final FindCustomerByInputPort customerByInputPort;
    private final DeleteCustomerOutputPort deleteCustomerOutputPort;


    public DeleteCustomerUseCase(
            FindCustomerByInputPort customerByInputPort,
            DeleteCustomerOutputPort deleteCustomerOutputPort
    ) {
        this.customerByInputPort = customerByInputPort;
        this.deleteCustomerOutputPort = deleteCustomerOutputPort;
    }


    @Override
    public void delete(String id) {
        customerByInputPort.find(id);
        deleteCustomerOutputPort.delete(id);
    }
}
