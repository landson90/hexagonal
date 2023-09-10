package com.land.hexagonal.adapters.out.client.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdressResponseClient {

    private String street;
    private String city;
    private String state;

}
