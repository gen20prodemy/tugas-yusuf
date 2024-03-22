package org.sigmaka.gen20javaspringbootpos.dto;

import org.sigmaka.gen20javaspringbootpos.entity.CustomerEntity;

import java.sql.Timestamp;

public class CustomersDTO {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerEntity dtoToEntity(){
        CustomerEntity customers = new CustomerEntity();

        customers.setName(name);
        customers.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        customers.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        return customers;
    }
}
