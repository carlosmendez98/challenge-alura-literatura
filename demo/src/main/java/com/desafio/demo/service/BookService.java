package com.desafio.demo.service;

import com.desafio.demo.Repository.BookRepository;
import com.desafio.demo.model.Author;
import com.desafio.demo.model.Book;
import com.desafio.demo.model.Dto.DatosAuthor;
import com.desafio.demo.model.Dto.DatosLibros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookService {

    @Autowired
     private BookRepository bookRepository;


    public List<DatosLibros> listaLibros(){

        List<DatosLibros> libros;
        return libros = this.bookRepository.findAll().stream()
                .map(book -> new DatosLibros(book.getTitulo(),
                        book.getAuthors().stream().map(author ->
                                new DatosAuthor(author.getName(),
                                        author.getBirth_year(),
                                        author.getDeath_year())).toList(),
                        book.getLenguaje(), book.getNumero_descargas())).toList();


    }
    public void guardarLibro(DatosLibros datosLibros){

        Book libro = new Book(
                datosLibros.titulo(), datosLibros.authors().stream()
                .map(dto -> {
                    Author autor = new Author();
                    autor.setName(dto.name());
                    autor.setBirth_year(dto.birth_year());
                    autor.setDeath_year(dto.death_year());
                    return autor;
                })
                .toList()
                ,datosLibros.lenguaje(),datosLibros.numero_descargas());
        this.bookRepository.save(libro);

    }



    // faltaria filtrar libro por idioma si quiero por idioma

}
