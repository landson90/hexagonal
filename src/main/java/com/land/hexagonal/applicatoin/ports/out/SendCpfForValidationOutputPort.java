package com.land.hexagonal.applicatoin.ports.out;

public interface SendCpfForValidationOutputPort {

    void send(String cpf);
}
