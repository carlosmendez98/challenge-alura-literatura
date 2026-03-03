package com.desafio.demo.model;

import com.desafio.demo.model.Dto.DatosAuthor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {

    public Book() {
    }

    public Book(String titulo, List<Author> authors, List<String> lenguaje, long numero_descargas) {
        this.titulo = titulo;
        this.authors = authors;
        this.lenguaje = lenguaje;
        this.numero_descargas = numero_descargas;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonAlias("title")
    private String titulo;

    @JsonAlias("authors")
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    private List<Author> authors;

    @JsonAlias("languages")
    private List<String> lenguaje;

    @JsonAlias("download_count")
    private long numero_descargas;




    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public List<String> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<String> lenguaje) {
        this.lenguaje = lenguaje;
    }

    public long getNumero_descargas() {
        return numero_descargas;
    }

    public void setNumero_descargas(long numero_descargas) {
        this.numero_descargas = numero_descargas;
    }


    public int getId_Book() {
        return id;
    }

    public void setId_Book(int id_Book) {
        this.id= id_Book;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + authors +
                ", lenguaje='" + lenguaje + '\'' +
                ", numero de descargas=" + numero_descargas +
                '}';
    }
}
