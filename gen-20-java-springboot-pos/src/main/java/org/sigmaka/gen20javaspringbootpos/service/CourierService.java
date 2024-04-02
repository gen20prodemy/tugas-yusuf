package org.sigmaka.gen20javaspringbootpos.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.sigmaka.gen20javaspringbootpos.dto.courier.*;
import org.sigmaka.gen20javaspringbootpos.helper.GlobalHttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CourierService {
    @Autowired
    private RestTemplate restTemplate;

    private final String apiKey = "1532177c781b5b272b98af8b223cb183";
    private final String baseUrl = "https://api.rajaongkir.com/starter/";


    public GlobalHttpResponse<List<ProvinceResponseDTO>> getProvince(){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            var body = restTemplate.exchange(
                    baseUrl + "province",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    }
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");

            List<Map<String, String>> results = (List<Map<String, String>>) rajaongkir.get("results");

            // Convert the list of maps to a list of ProvinceResponseDTO
            List<ProvinceResponseDTO> provinceResponseDTO = new ArrayList<>();
            for (Map<String, String> data : results) {
                provinceResponseDTO.add(new ProvinceResponseDTO(data.get("province_id"), data.get("province")));
            }

            return new GlobalHttpResponse<>(200, "Success retrieve data", provinceResponseDTO);

        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new ArrayList<>());
        } catch (RestClientException e){
            return new GlobalHttpResponse<>(500, "Internal Server Error", new ArrayList<>());
        }
    }

    public GlobalHttpResponse<ProvinceResponseDTO> getProvinceById(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            var body = restTemplate.exchange(
                    baseUrl + "province?id=" + id,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    }
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");

            ProvinceResponseDTO results = (ProvinceResponseDTO) rajaongkir.get("results");

            return new GlobalHttpResponse<>(200, "Success retrieve data", results);

        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new ProvinceResponseDTO());
        } catch (RestClientException e){
            return new GlobalHttpResponse<>(500, "Internal Server Error", new ProvinceResponseDTO());
        }
    }

    public GlobalHttpResponse<List<CityResponseDTO>> getCity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            var body = restTemplate.exchange(
                    baseUrl + "city",
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {
                    }
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");
            List<Map<String, String>> results = (List<Map<String, String>>) rajaongkir.get("results");

            // Convert the list of maps to a list of ProvinceResponseDTO
            List<CityResponseDTO> cityResponseDto = new ArrayList<>();
            for (Map<String, String> data : results) {
                cityResponseDto.add(
                        new CityResponseDTO(
                                data.get("city_id"),
                                data.get("province_id"),
                                data.get("province"),
                                data.get("type"),
                                data.get("city_name"),
                                data.get("postal_code")));
            }

            return new GlobalHttpResponse<>(200, "Success retrieve data", cityResponseDto);

        } catch (HttpClientErrorException.BadRequest e) {
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new ArrayList<>());
        } catch (RestClientException e) {
            return new GlobalHttpResponse<>(500, "Internal Server Error", new ArrayList<>());
        }
    }

    public GlobalHttpResponse<CityResponseDTO> getCityById(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            var body = restTemplate.exchange(
                    baseUrl + "city?id=" + id,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {}
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");
            CityResponseDTO results = (CityResponseDTO) rajaongkir.get("results");


            return new GlobalHttpResponse<>(200, "Success retrieve data", results);

        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new CityResponseDTO());
        } catch (RestClientException e){
            e.printStackTrace();
            return new GlobalHttpResponse<>(500, "Internal Server Error", new CityResponseDTO());
        }
    }

    public GlobalHttpResponse<List<CostsResultResponseDTO>> getCost(CostRequestDTO costRequestDTO){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String requestBody = objectMapper.writeValueAsString(costRequestDTO);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setContentLength(requestBody.length());
            HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);
            var body = restTemplate.exchange(
                    baseUrl + "cost",
                    HttpMethod.POST,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {}
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");
            List<CostsResultResponseDTO> result = (List<CostsResultResponseDTO>) rajaongkir.get("results");

            return new GlobalHttpResponse<>(200, "Success retrieve data", result);
        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new ArrayList<>());
        } catch (RestClientException e){
            return new GlobalHttpResponse<>(500, "Internal Server Error", new ArrayList<>());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
