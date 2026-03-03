package com.desafio.demo.service;


import com.desafio.demo.Repository.AuthorRepository;
import com.desafio.demo.model.Dto.DatosAuthor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service

public class AuthoresService {

@Autowired
    private AuthorRepository authorRepository;


    public List<DatosAuthor> listaAuthoresVivosDeterminado(int year) {
        List<DatosAuthor> autoresVivos = this.authorRepository.findAll().stream()
                .map(m -> new DatosAuthor(m.getName(), m.getBirth_year(), m.getDeath_year()))
                .filter(autores -> autores.birth_year() <= year &&
                        (autores.death_year() > year || autores.death_year() == null)).toList();

        return autoresVivos;

    }

    public List<DatosAuthor> listadoAuthores(){
        List<DatosAuthor> datosAuthores;
        return  datosAuthores = this.authorRepository.findAll().stream()
                .map(author -> new DatosAuthor(author.getName(),author.getBirth_year(),author.getDeath_year()))
                .toList();
    }

}
