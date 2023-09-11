package com.land.hexagonal.adapters.in.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponse {

    private String name;
    private String cpf;
    private Boolean isValidCpf;
    private AddressResponse addressResponse;

}
