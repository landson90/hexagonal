package com.land.hexagonal.adapters.out.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "address")
public class AddressEnity {

    private String street;
    private String city;
    private String state;

}
