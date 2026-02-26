package com.veterinaria.api.controller;

import com.veterinaria.api.models.MascotaAdopcion;
import com.veterinaria.api.repository.MascotaAdopcionRepository;
import com.veterinaria.api.service.MascotaAdopcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adopciones")
@CrossOrigin(origins = "*")
public class MascotaAdopcionController {

    @Autowired
    private MascotaAdopcionService service;
    @Autowired
    private MascotaAdopcionRepository repository;

    // 1. ENDPOINT PARA GUARDAR
    @PostMapping("/guardar")
    public ResponseEntity<MascotaAdopcion> guardar(@RequestBody MascotaAdopcion mascota) {
        MascotaAdopcion nuevaMascota = service.guardar(mascota);
        return new ResponseEntity<>(nuevaMascota, HttpStatus.CREATED);
    }

    // 2. ENDPOINT PARA EDITAR
    @PutMapping("/editar/{id}")
    public ResponseEntity<MascotaAdopcion> editar(@PathVariable String id, @RequestBody MascotaAdopcion detalles) {
        MascotaAdopcion mascotaEditada = service.editar(id, detalles);
        if (mascotaEditada != null) {
            return ResponseEntity.ok(mascotaEditada);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MascotaAdopcion>> listar() {
        List<MascotaAdopcion> mascotas = repository.findAll();
        return ResponseEntity.ok(mascotas);
    }

    // 3. ENDPOINT PARA ELIMINAR (Con validación de estado)
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminar(@PathVariable String id) {
        boolean eliminado = service.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Mascota eliminada exitosamente.");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("No se puede eliminar: La mascota no existe o ya no está disponible.");
    }
}