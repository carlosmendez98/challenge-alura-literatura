package com.desafio.demo.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JsonAlias("name")
    private String name;

    private int birth_year;

    private int death_year;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL)
    private List<Book> libros;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;
    }

    public int getDeath_year() {
        return death_year;
    }

    public void setDeath_year(int death_year) {
        this.death_year = death_year;
    }


    @Override
    public String toString() {
        return "Author{" +
                " name='" + name + '\'' +
                ", birth_year=" + birth_year +
                ", death_year=" + death_year +
                '}';
    }
}
