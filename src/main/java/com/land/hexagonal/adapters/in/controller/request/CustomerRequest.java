package com.land.hexagonal.adapters.in.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {


    private String name;
    private String cpf;
    private String zipCode;
}
