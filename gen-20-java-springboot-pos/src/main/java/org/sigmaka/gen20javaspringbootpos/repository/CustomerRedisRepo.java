package org.sigmaka.gen20javaspringbootpos.repository;

import org.sigmaka.gen20javaspringbootpos.entity.CustomerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Repository
public class CustomerRedisRepo {
    public static final String HASH_KEY = "Customer";
    @Autowired
    private RedisTemplate redisTemplate;

    public CustomerEntity save(CustomerEntity customer) {
//        redisTemplate.opsForHash().put(HASH_KEY, customer.getId(), customer);
        redisTemplate.opsForValue().set("customer:"+customer.getId(), customer);
        return customer;
    }

    public List<CustomerEntity> findAll(){
//        return redisTemplate.opsForHash().values(HASH_KEY);
        Set<String> keys = redisTemplate.keys("customer:" + "*"); // Retrieve all keys
        List<CustomerEntity> customers = new ArrayList<>();
        for (String key : keys) {
            customers.add((CustomerEntity) redisTemplate.opsForValue().get(key)); // Retrieve value for each key
        }
        return customers;
    }

    public CustomerEntity findCustomerById(int id){
//        return (CustomerEntity) redisTemplate.opsForHash().get(HASH_KEY, id);
        return (CustomerEntity) redisTemplate.opsForValue().get("customer:"+id);
    }

    public String deleteCustomer(int id){
//        redisTemplate.opsForHash().delete(HASH_KEY, id);
        redisTemplate.delete("customer"+id);
        return "categories removed";
    }
}
