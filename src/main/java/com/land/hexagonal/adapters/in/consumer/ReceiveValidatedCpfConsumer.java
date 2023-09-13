package com.land.hexagonal.adapters.in.consumer;


import com.land.hexagonal.adapters.in.consumer.mapper.CustomerMessageMapper;
import com.land.hexagonal.adapters.in.consumer.message.CustomerMessage;
import com.land.hexagonal.applicatoin.ports.in.UpdateCustomerInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiveValidatedCpfConsumer {

    private UpdateCustomerInputPort updateCustomerInputPort;
    private CustomerMessageMapper mapper;
    @Autowired
    public ReceiveValidatedCpfConsumer(UpdateCustomerInputPort updateCustomerInputPort, CustomerMessageMapper mapper) {
        this.updateCustomerInputPort = updateCustomerInputPort;
        this.mapper = mapper;
    }

    @KafkaListener(topics = "tp-cpf-validated", groupId = "arantes")
    public void receive(CustomerMessage customerMessage) {
        var customerDomain = this.mapper.toCostomer(customerMessage);
        this.updateCustomerInputPort.update(customerDomain, customerMessage.getZipCode());
    }
}
