package com.parcial.biblioteca.service;

import com.parcial.biblioteca.entity.Biblioteca;
import com.parcial.biblioteca.repository.BibliotecaRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {

    private final BibliotecaRepository bibliotecaRepository;

    public BibliotecaService(BibliotecaRepository bibliotecaRepository) {
        this.bibliotecaRepository = bibliotecaRepository;
    }

    public Biblioteca crear(Biblioteca biblioteca) {
        return bibliotecaRepository.save(biblioteca);
    }

    public List<Biblioteca> listar() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca buscarPorId(Long id) {
        return bibliotecaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Biblioteca no encontrada"));
    }

    public Biblioteca actualizar(Long id, Biblioteca datos) {
        Biblioteca biblioteca = buscarPorId(id);
        biblioteca.setNombre(datos.getNombre());
        biblioteca.setDireccion(datos.getDireccion());
        biblioteca.setTelefono(datos.getTelefono());
        biblioteca.setResponsable(datos.getResponsable());
        return bibliotecaRepository.save(biblioteca);
    }

    public void eliminar(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}
