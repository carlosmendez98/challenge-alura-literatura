package com.desafio.demo.service;



import com.desafio.demo.model.Dto.DatosLibros;
import com.desafio.demo.model.Results;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionApi {


  ObjectMapper objectMapper = new ObjectMapper();


    public DatosLibros conectarDatosLibro(String nombreLibro) throws IOException, InterruptedException {

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://gutendex.com/books/?search="+ nombreLibro)) // url para los libros
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        Results result= this.objectMapper.readValue(response.body(), Results.class);

        return result.getObtenerPrimerLibro();
    }




}
