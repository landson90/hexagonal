package com.land.hexagonal.adapters.out.client;


import com.land.hexagonal.adapters.out.client.response.AdressResponseClient;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "arantes.client.adress.url"
)
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}")
    AdressResponseClient find(@PathVariable("zipCode") String zipCode);
}
