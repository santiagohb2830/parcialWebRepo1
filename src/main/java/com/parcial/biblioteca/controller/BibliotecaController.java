package com.parcial.biblioteca.controller;

import com.parcial.biblioteca.entity.Biblioteca;
import com.parcial.biblioteca.service.BibliotecaService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bibliotecas")
@CrossOrigin(origins = "*")
public class BibliotecaController {

    private final BibliotecaService bibliotecaService;

    public BibliotecaController(BibliotecaService bibliotecaService) {
        this.bibliotecaService = bibliotecaService;
    }

    @PostMapping
    public ResponseEntity<Biblioteca> crear(@RequestBody Biblioteca biblioteca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(bibliotecaService.crear(biblioteca));
    }

    @GetMapping
    public ResponseEntity<List<Biblioteca>> listar() {
        return ResponseEntity.ok(bibliotecaService.listar());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(bibliotecaService.buscarPorId(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Biblioteca> actualizar(@PathVariable Long id, @RequestBody Biblioteca biblioteca) {
        return ResponseEntity.ok(bibliotecaService.actualizar(id, biblioteca));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        bibliotecaService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
