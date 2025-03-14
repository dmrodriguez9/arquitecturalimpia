/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espe.mslibros.infraestructura;

import ec.edu.espe.mslibros.dominio.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USER
 */
public interface RepositorioAutor extends JpaRepository<Autor, Long> {
    
}
