package com.israeloliveiradev.adapters.outbound.feignClients;

import com.israeloliveiradev.adapters.inbound.dtos.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepClient {

    @GetMapping("/{cep}/json")
    AddressResponse getAddressByZipCode(@PathVariable("cep") String zipCode);
}

