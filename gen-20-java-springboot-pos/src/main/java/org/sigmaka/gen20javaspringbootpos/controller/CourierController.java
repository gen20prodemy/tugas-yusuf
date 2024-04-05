package org.sigmaka.gen20javaspringbootpos.controller;

import org.sigmaka.gen20javaspringbootpos.dto.courier.CityResponseDTO;
import org.sigmaka.gen20javaspringbootpos.dto.courier.CostRequestDTO;
import org.sigmaka.gen20javaspringbootpos.dto.courier.CostsResultResponseDTO;
import org.sigmaka.gen20javaspringbootpos.dto.courier.ProvinceResponseDTO;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.sigmaka.gen20javaspringbootpos.service.CourierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courier")
public class CourierController {
    @Autowired
    private CourierService courierService;

    @PostMapping("/")
    public ResponseEntity<GlobalHttpResponse<List<CostsResultResponseDTO>>> getCost(@RequestBody CostRequestDTO costRequestDTO){
        GlobalHttpResponse<List<CostsResultResponseDTO>> res = courierService.getCost(costRequestDTO);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @GetMapping("/province")
    public ResponseEntity<GlobalHttpResponse<List<ProvinceResponseDTO>>> getProvince() throws InterruptedException{
        courierService.acceptRequest();
        courierService.processingRequest();
        courierService.forwardingRequest();
        courierService.gettingResponseFromAPI();
        courierService.returningResponseToClient();
        GlobalHttpResponse<List<ProvinceResponseDTO>> res = courierService.getProvince();
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @GetMapping("/province/{id}")
    public ResponseEntity<GlobalHttpResponse<ProvinceResponseDTO>> getProvinceById(@PathVariable("id") String id){
        GlobalHttpResponse<ProvinceResponseDTO> res = courierService.getProvinceById(id);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @GetMapping("/city")
    public ResponseEntity<GlobalHttpResponse<List<CityResponseDTO>>> getCity(){
        GlobalHttpResponse<List<CityResponseDTO>> res = courierService.getCity();
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @GetMapping("/city/province/{id}")
    public ResponseEntity<GlobalHttpResponse<List<CityResponseDTO>>> getCityByProvinceId(@PathVariable("id") String id){
        GlobalHttpResponse<List<CityResponseDTO>> res = courierService.getCityByProvinceId(id);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

    @GetMapping("/city/{id}")
    public ResponseEntity<GlobalHttpResponse<CityResponseDTO>> getCityById(@PathVariable("id") String id){
        GlobalHttpResponse<CityResponseDTO> res = courierService.getCityById(id);
        return new ResponseEntity<>(res, HttpStatusCode.valueOf(res.getStatusCode()));
    }

}
