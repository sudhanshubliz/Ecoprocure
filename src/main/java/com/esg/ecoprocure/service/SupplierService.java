package com.esg.ecoprocure.service;


import com.esg.ecoprocure.model.Items;
import com.esg.ecoprocure.model.ItemsMerge;
import com.esg.ecoprocure.model.Price;
import com.esg.ecoprocure.repository.SupplierRepository;
import com.esg.ecoprocure.model.Supplier;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    RestTemplate restTemplate;

    public List<Supplier> getAll() {
        return supplierRepository.findAll();
    }

    public List<ItemsMerge> getBySupplierId(long id) throws IOException, InterruptedException {

        String url = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_v2.json";
        String url1 = "https://s3.eu-west-1.amazonaws.com/hackajob-assets1.p.hackajob/challenges/sainsbury_products/products_price_v2.json";

        Result result = getResult(url);

        Result result1 = getResult(url1);


        // Parse JSON string to PaddleSubscriptionResponse object
        try {
            List<Items> items =  result.objectMapper().readValue(result.body(),  new TypeReference<List<Items>>(){});

            List<Price> price = result1.objectMapper().readValue(result1.body(),new TypeReference<List<Price>>(){});

            List<ItemsMerge> imList = new ArrayList<>();

            IntStream.range(0, items.size()).forEach(i->{

                if(items.get(i).getProduct_uid().equals(price.get(i).getProduct_uid())){
                    ItemsMerge im = new ItemsMerge();
                    im.setProduct_uid(items.get(i).getProduct_uid());
                    im.setName(items.get(i).getName());
                    im.setFull_url(items.get(i).getFull_url());
                    im.setProduct_type(items.get(i).getProduct_type());
                    im.setUnit_price(price.get(i).getUnit_price());
                    im.setUnit_price_measure(price.get(i).getUnit_price_measure());
                    im.setUnit_price_measure_amount(price.get(i).getUnit_price_measure_amount());
                    imList.add(im);

                }
            });
                return imList;




         // System.out.println(result.objectMapper().readValue(result.body(), Items.class));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


       // Optional<Supplier>  supplier = supplierRepository.findById(id);
//        if(supplier.isPresent()){
//            supplierRepository.findById(id);
//        }
      //  return supplier;
    }

    private static Result getResult(String url) throws IOException, InterruptedException {
        java.net.http.HttpRequest httpRequest = java.net.http.HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
//                .method("PATCH", java.net.http.HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        String body = httpResponse.body();
        ObjectMapper objectMapper = new ObjectMapper();
        Result result = new Result(body, objectMapper);
        return result;
    }

    private record Result(String body, ObjectMapper objectMapper) {
    }

}
