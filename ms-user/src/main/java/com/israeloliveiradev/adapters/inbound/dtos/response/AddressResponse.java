package com.israeloliveiradev.adapters.inbound.dtos.response;

import lombok.Data;


@Data
public class AddressResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
}
