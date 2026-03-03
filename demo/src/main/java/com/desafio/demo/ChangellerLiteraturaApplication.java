package com.desafio.demo;

import com.desafio.demo.model.Dto.DatosAuthor;
import com.desafio.demo.model.Dto.DatosLibros;
import com.desafio.demo.service.AuthoresService;
import com.desafio.demo.service.BookService;
import com.desafio.demo.service.ConexionApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ChangellerLiteraturaApplication implements CommandLineRunner {


 private final BookService bookService;
 private final AuthoresService authoresService;

public ChangellerLiteraturaApplication(BookService bookService, AuthoresService authoresService){
    this.bookService = bookService;
    this.authoresService = authoresService;

}
    public static void main(String[] args) {
        SpringApplication.run(ChangellerLiteraturaApplication.class, args);


    }


    @Override
    public void run(String... args) throws Exception {



        int numero0 = 1;
        Scanner entrada = new Scanner(System.in);

        var conexionApi = new ConexionApi();




        while (numero0 != 0) {
            System.out.println("------------------------------");
            System.out.println("Elija la opción a travéz de su número:");


            System.out.println(
                    "\t\t1- buscar libro por título\n" +
                            "\t\t2- listar líbros registrados\n" +
                            "\t\t3- listar autores registrados\n" +
                            "\t\t4- listar autores vivos en un determinado año\n" +
                            "\t\t5- listar libros por idioma\n" +
                            "\t\t0 - salir ); ");
            numero0 = entrada.nextInt();
entrada.nextLine();



            switch (numero0) {


                case 1:
                    System.out.println("Buscar libro por título");
                    var nombreLibro = entrada.nextLine();
                    DatosLibros libro = conexionApi.conectarDatosLibro(nombreLibro);
                   this.bookService.guardarLibro(libro);

                    break;

                case 2:
                    System.out.println("Listar libros registrados");

                    List<DatosLibros> datosLibro =   bookService.listaLibros();
                    for (DatosLibros datos : datosLibro) {
                        System.out.println("***************** ");
                        System.out.println("Título: " + datos.titulo());
                        System.out.println("Lenguaje: " + datos.lenguaje());
                        System.out.println("Descargas: " + datos.numero_descargas());

                        for (DatosAuthor autor : datos.authors()) {
                            System.out.println("Autor: " + autor.name());
                            System.out.println("Nacimiento: " + autor.birth_year());
                            System.out.println("Muerte: " + autor.death_year());
                        }
                    }

                    break;

                case 3:

                    System.out.println("Listar autores registrados");
List<DatosAuthor> datos = this.authoresService.listadoAuthores();
                    for (DatosAuthor autor : datos) {
                        System.out.println("***************** ");
                        System.out.println("Autor: " + autor.name());
                        System.out.println("Nacimiento: " + autor.birth_year());
                        System.out.println("Muerte: " + autor.death_year());
                    }

                    break;

                case 4:
                    System.out.println("Listar autores vivos en un determinado año");
                    System.out.println("Por favor ingresar un año determinado");

                    var year = entrada.nextInt();
                    entrada.nextLine();
                    List<DatosAuthor>  datosAuthorsVivos = this.authoresService.listaAuthoresVivosDeterminado(year);
                    for (DatosAuthor autor : datosAuthorsVivos) {
                        System.out.println("***************** ");
                        System.out.println("Autor: " + autor.name());
                        System.out.println("Nacimiento: " + autor.birth_year());
                        System.out.println("Muerte: " + autor.death_year());
                    }

                    break;

                case 5:
                    System.out.println("Listar libros por idioma");

                    List<DatosLibros> datosLibroIdioma = this.bookService.listaLibros();

                    for (DatosLibros datosIdiomas : datosLibroIdioma) {
                        System.out.println("***************** ");
                        System.out.println("Título: " + datosIdiomas.titulo());
                        System.out.println("Lenguaje: " + datosIdiomas.lenguaje());

                    }
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }




        /*

             if (libro == null) {
                System.out.println("No se encontró ningún libro");
                return;
            }
         */

//			System.out.println("Titulo: " + libro.titulo());
//		System.out.println("Lenguaje del libro:" + libro.lenguaje());
//		System.out.println("número De Descargas: " + libro.numero_descargas());
//		System.out.println(libro.authors().stream().map(e -> e.name()).toList());
//		System.out.println();


    }
}
