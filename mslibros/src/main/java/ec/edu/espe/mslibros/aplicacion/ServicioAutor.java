/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.mslibros.aplicacion;

import ec.edu.espe.mslibros.dominio.Autor;
import ec.edu.espe.mslibros.infraestructura.RepositorioAutor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USER
 */

@Service
public class ServicioAutor {
    
    @Autowired
    private RepositorioAutor repositorioAutor;

    public Autor crearAutor(Autor autor){
        return repositorioAutor.save(autor);
    }

    public List<Autor> obtenerTodos(){
        return repositorioAutor.findAll();
    }

    public Optional<Autor> obtenerAutor(Long id){
        return repositorioAutor.findById(id);
    }

    public Autor actualizarAutor(Autor autor){
        try{
            if (obtenerAutor(autor.getId()).get() != null){
                return repositorioAutor.save(autor);
            } else {
                throw new Exception("Error al editar el autor"); 
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return autor;
    }
    
    public void eliminarAutor(Long id){
        repositorioAutor.deleteById(id);
    }

}
