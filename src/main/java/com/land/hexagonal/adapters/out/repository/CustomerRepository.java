package com.land.hexagonal.adapters.out.repository;

import com.land.hexagonal.adapters.out.repository.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
