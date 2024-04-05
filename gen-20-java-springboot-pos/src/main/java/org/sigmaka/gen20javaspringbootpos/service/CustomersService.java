package org.sigmaka.gen20javaspringbootpos.service;

import org.sigmaka.gen20javaspringbootpos.dto.CustomersDTO;
import org.sigmaka.gen20javaspringbootpos.entity.CustomerEntity;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.repository.CustomerRedisRepo;
import org.sigmaka.gen20javaspringbootpos.repository.CustomersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepo customersRepo;
    private CustomerRedisRepo customerRedisRepo;

    @Autowired
    public CustomersService(CustomersRepo customersRepo, CustomerRedisRepo customerRedisRepo) {
        this.customersRepo = customersRepo;
        this.customerRedisRepo = customerRedisRepo;
    }

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

    public GlobalHttpResponse<CustomerEntity> insertCache(CustomerEntity customerEntity){
        customerEntity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        customerEntity.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        CustomerEntity customer = customerRedisRepo.save(customerEntity);

        return new GlobalHttpResponse<>(200, "Cached successfully", customer);
    }

    public GlobalHttpResponse<List<CustomerEntity>> getAllCached(){
        List<CustomerEntity> customers = customerRedisRepo.findAll();

        return new GlobalHttpResponse<>(200, "Successfully get cached data", customers);
    }

    public GlobalHttpResponse<CustomerEntity> getCachedById(int id){
        CustomerEntity customer = customerRedisRepo.findCustomerById(id);

        return new GlobalHttpResponse<>(200, "success retrieve cached data", customer);
    }
}
