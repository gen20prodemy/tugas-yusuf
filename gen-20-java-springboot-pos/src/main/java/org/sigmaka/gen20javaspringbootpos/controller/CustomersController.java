package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.CustomersDTO;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.CustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/customer")
public class CustomersController {
    @Autowired
    private CustomersService customersService;

    @GetMapping("/")
    @Scheduled(cron = "*/30 * * * * *")
    public ResponseEntity<GlobalHttpResponse<List<CustomersDTO>>> getAll(){
        GlobalHttpResponse<List<CustomersDTO>> result = customersService.findAll();
        System.out.println(result.toString());
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }

    @PostMapping("/")
    public ResponseEntity<GlobalHttpResponse<String>> insert(@RequestBody CustomersDTO customersDTO){
        GlobalHttpResponse<String> result = customersService.insert(customersDTO);
        return new ResponseEntity<>(result, HttpStatusCode.valueOf(result.getStatusCode()));
    }
}
