package com.desafio.demo.model.Dto;

import com.desafio.demo.model.Author;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.ManyToMany;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibros(@JsonAlias("title") String titulo,
                          @JsonAlias("authors") List<DatosAuthor> authors,
                          @JsonAlias("languages") List<String> lenguaje,
                          @JsonAlias("download_count") Long numero_descargas)


{


}
