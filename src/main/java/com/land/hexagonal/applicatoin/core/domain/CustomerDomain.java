package com.land.hexagonal.applicatoin.core.domain;

public class CustomerDomain {

    private String id;
    private String name;
    private AddressDomain address;
    private String cpf;
    private Boolean isValidCpf;

    public CustomerDomain() {
        this.isValidCpf = false;
    }


    public CustomerDomain(String id, String name, AddressDomain address, String cpf, Boolean isValidCpf) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.isValidCpf = isValidCpf;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDomain getAddress() {
        return address;
    }

    public void setAddress(AddressDomain address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getValidCpf() {
        return isValidCpf;
    }

    public void setValidCpf(Boolean validCpf) {
        isValidCpf = validCpf;
    }
}
