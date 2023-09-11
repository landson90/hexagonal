package com.land.hexagonal.adapters.out.repository.entity;

import com.land.hexagonal.applicatoin.core.domain.AddressDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collation = "customers")
public class CustomerEntity {

    @Id
    private String id;
    private String name;
    private AddressEnity address;
    private String cpf;
    private Boolean isValidCpf;
}
