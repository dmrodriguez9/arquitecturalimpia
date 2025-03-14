/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mslibros.aplicacion;

import ec.edu.espe.mslibros.dominio.Libro;
import ec.edu.espe.mslibros.infraestructura.RepositorioAutor;
import ec.edu.espe.mslibros.infraestructura.RepositorioLibro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class ServicioLibro {
    
     @Autowired
    private RepositorioLibro repositorioLibro;

    @Autowired
    private RepositorioAutor repositorioAutor;

    public Libro crearLibro(Long idAutor, Libro libro) {
        return repositorioAutor.findById(idAutor).map(autor -> {
            libro.setAutor(autor);
            return repositorioLibro.save(libro);
        }).orElseThrow(() -> new RuntimeException("Autor no encontrado con ID: " + idAutor));
    }

    public List<Libro> obtenerTodos() {
        return repositorioLibro.findAll();
    }

    public Optional<Libro> obtenerLibro(Long id) {
        return repositorioLibro.findById(id);
    }

    public Libro actualizarLibro(Long id, String titulo, int anio, String isbn) {
        return repositorioLibro.findById(id).map(libro -> {
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setIsbn(isbn);
            return repositorioLibro.save(libro);
        }).orElseThrow(() -> new RuntimeException("Libro no encontrado con ID: " + id));
    }

    public void eliminarLibro(Long id) {
        if (!repositorioLibro.existsById(id)) {
            throw new RuntimeException("Libro no encontrado con ID: " + id);
        }
        repositorioLibro.deleteById(id);
    }
    
}
