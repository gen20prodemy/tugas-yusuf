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
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Service
public class CourierService {
    @Autowired
    private RestTemplate restTemplate;
    private static final Logger log = Logger.getLogger(CourierService.class.getName());

    private final String apiKey = "1532177c781b5b272b98af8b223cb183";
    private final String baseUrl = "https://api.rajaongkir.com/starter/";

    @Async("asyncTaskExecutor")
    public void acceptRequest() throws InterruptedException {
        Thread.sleep(3000L);
        log.info("Accepting Request from Client " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void processingRequest() throws InterruptedException {
        Thread.sleep(4000L);
        log.info("Processing Request from Client " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void forwardingRequest() throws InterruptedException {
        Thread.sleep(5000L);
        log.info("Forwarding Request to API " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void gettingResponseFromAPI() throws InterruptedException {
        Thread.sleep(6000L);
        log.info("Getting Response from API " + Thread.currentThread().getName());
    }

    @Async("asyncTaskExecutor")
    public void returningResponseToClient() throws InterruptedException {
        Thread.sleep(3000L);
        log.info("Sending Response to Client " + Thread.currentThread().getName());
    }

    public GlobalHttpResponse<List<ProvinceResponseDTO>> getProvince() throws InterruptedException{
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

            Map<String, String> results = (Map<String, String>) rajaongkir.get("results");
            ProvinceResponseDTO province = new ProvinceResponseDTO(results.get("province_id"), results.get("province"));

            return new GlobalHttpResponse<>(200, "Success retrieve data", province);

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
            Map<String, String> results = (Map<String, String>) rajaongkir.get("results");
            CityResponseDTO city = new CityResponseDTO(
                    results.get("city_id"),
                    results.get("province_id"),
                    results.get("province"),
                    results.get("type"),
                    results.get("city_name"),
                    results.get("postal_code")
            );

            return new GlobalHttpResponse<>(200, "Success retrieve data", city);

        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new CityResponseDTO());
        } catch (RestClientException e){
            e.printStackTrace();
            return new GlobalHttpResponse<>(500, "Internal Server Error", new CityResponseDTO());
        }
    }

    public GlobalHttpResponse<List<CityResponseDTO>> getCityByProvinceId(String id){
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("key", apiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            var body = restTemplate.exchange(
                    baseUrl + "city?province=" + id,
                    HttpMethod.GET,
                    entity,
                    new ParameterizedTypeReference<Map<String, Object>>() {}
            ).getBody();
            Map<String, Object> rajaongkir = (Map<String, Object>) body.get("rajaongkir");
            List<Map<String, String>> results = (List<Map<String, String>>) rajaongkir.get("results");
            List<CityResponseDTO> city = new ArrayList<>();

            for(Map<String, String> data : results){
                city.add(new CityResponseDTO(
                        data.get("city_id"),
                        data.get("province_id"),
                        data.get("province"),
                        data.get("type"),
                        data.get("city_name"),
                        data.get("postal_code")
                ));
            }

            return new GlobalHttpResponse<>(200, "Success retrieve data", city);

        } catch (HttpClientErrorException.BadRequest e){
            return new GlobalHttpResponse<>(400, "Bad Request: Invalid API Key", new ArrayList<>());
        } catch (RestClientException e){
            e.printStackTrace();
            return new GlobalHttpResponse<>(500, "Internal Server Error", new ArrayList<>());
        }
    }

    @Async
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
