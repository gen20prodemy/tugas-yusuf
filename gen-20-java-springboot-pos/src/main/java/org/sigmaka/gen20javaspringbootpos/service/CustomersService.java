package org.sigmaka.gen20javaspringbootpos.service;

import org.sigmaka.gen20javaspringbootpos.dto.CustomersDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CustomerEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    @Autowired
    private CustomersRepo customersRepo;

    public GlobalHttpResponse<List<CustomersDTO>> findAll(){
        List<CustomerEntity> customers = customersRepo.findAllCustomersJPQL();
        List<CustomersDTO> result = new ArrayList<>();

        for(CustomerEntity data : customers){
            result.add(data.entityToDto());
        }

        return new GlobalHttpResponse<>(200, "Success retrieve data", result);
    }

    public GlobalHttpResponse<String > insert(CustomersDTO customersDTO){
        try{
            CustomerEntity newCust = customersDTO.dtoToEntity();
            customersRepo.insertCustomerNative(newCust.getName(), newCust.getCreatedAt(), newCust.getUpdatedAt());

            return new GlobalHttpResponse<>(201, "Success insert new data", "Data successfully added to database");

        } catch (Exception e){
            return new GlobalHttpResponse<>(500, "Something went wrong", e.getMessage());
        }
    }
}
