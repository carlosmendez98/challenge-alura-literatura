package com.desafio.demo.model;


import com.desafio.demo.model.Dto.DatosLibros;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Results {

    @JsonAlias("results")
    private List<DatosLibros> books;


    public List<DatosLibros> getBooks() {
        return books;
    }

    public void setBooks(List<DatosLibros> books) {
        this.books = books;
    }

    public DatosLibros getObtenerPrimerLibro() {
        if (books == null || books.isEmpty()) {
            return null;
        }
        return books.getFirst();
    }
}
