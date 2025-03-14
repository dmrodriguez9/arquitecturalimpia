/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mslibros.presentacion;

import ec.edu.espe.mslibros.aplicacion.ServicioAutor;
import ec.edu.espe.mslibros.aplicacion.ServicioLibro;
import ec.edu.espe.mslibros.dominio.Autor;
import ec.edu.espe.mslibros.dominio.Libro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USER
 */

@RestController
public class ApiController {
    
   @Autowired 
   private ServicioAutor servicioAutor;
   
   @Autowired
   private ServicioLibro servicioLibro;
   
   @QueryMapping
   public List<Autor> obtenerAutores(){
       return servicioAutor.obtenerTodos();
   }
   
   @QueryMapping
   public Autor obtenerAutor(@Argument Long id){
       return servicioAutor.obtenerAutor(id).orElse(null);
   }
   
   public Autor crearAutor(@Argument String nombre, @Argument String apellido, @Argument String correo ){
         Autor autor = new Autor();
            autor.setNombre(nombre);
            autor.setApellido(apellido);
            autor.setCorreo(correo);
       return servicioAutor.crearAutor(autor);
   }
   
   public Autor updateAutor(@Argument Long id, @Argument String nombre, @Argument String apellido, @Argument String correo){
       Optional<Autor> autorExistente = servicioAutor.obtenerAutor(id);
       if(autorExistente.isPresent()){
           Autor autor = autorExistente.get();
           autor.setNombre(nombre);
           autor.setApellido(apellido);
           autor.setCorreo(correo);
           return servicioAutor.actualizarAutor(autor);
       } else {
           throw new RuntimeException("Autor no encontrado con ID: " + id);
       }
   }
   
   public Boolean deleteAutor(@Argument Long id){
       Optional<Autor> autorExistente = servicioAutor.obtenerAutor(id);
       if(autorExistente.isPresent()){
           servicioAutor.eliminarAutor(id);
           return true;
       } else {
           throw new RuntimeException("Autor no encontrado con ID: " + id);
       }
   }
   
   
   // ------------------- Métodos para Libros -------------------
   
   @QueryMapping
   public List<Libro> obtenerLibros() {
       return servicioLibro.obtenerTodos();
   }

   @QueryMapping
   public Libro obtenerLibro(@Argument Long id) {
       return servicioLibro.obtenerLibro(id).orElse(null);
   }

   
   public Libro crearLibro(@Argument Long idAutor, @Argument String titulo, @Argument int anio, @Argument String isbn) {
       Libro libro = new Libro();
       libro.setTitulo(titulo);
       libro.setAnio(anio);
       libro.setIsbn(isbn);
       return servicioLibro.crearLibro(idAutor, libro);
   }

   
   public Libro actualizarLibro(@Argument Long id, @Argument String titulo, @Argument int anio, @Argument String isbn) {
       return servicioLibro.actualizarLibro(id, titulo, anio, isbn);
   }

 
   public Boolean eliminarLibro(@Argument Long id) {
       Optional<Libro> libroExistente = servicioLibro.obtenerLibro(id);
       if (libroExistente.isPresent()) {
           servicioLibro.eliminarLibro(id);
           return true;
       } else {
           throw new RuntimeException("Libro no encontrado con ID: " + id);
       }
   }
  
}

