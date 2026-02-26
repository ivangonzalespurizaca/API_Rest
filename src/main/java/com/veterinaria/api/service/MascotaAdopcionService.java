package com.veterinaria.api.service;

import com.veterinaria.api.models.MascotaAdopcion;
import com.veterinaria.api.repository.MascotaAdopcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MascotaAdopcionService {

    @Autowired
    private MascotaAdopcionRepository repository;

    // 1. MÉTODO GUARDAR
    public MascotaAdopcion guardar(MascotaAdopcion mascota) {
        return repository.save(mascota);
    }

    // 2. MÉTODO EDITAR
    public MascotaAdopcion editar(String id, MascotaAdopcion detalles) {
        return repository.findById(id).map(m -> {
            m.setNombre_mascota(detalles.getNombre_mascota());
            m.setSexo(detalles.getSexo());
            m.setId_especie(detalles.getId_especie());
            m.setId_raza(detalles.getId_raza());
            m.setEdad_estimada(detalles.getEdad_estimada());
            m.setDescripcion(detalles.getDescripcion());
            m.setContacto(detalles.getContacto());
            m.setEstado(detalles.getEstado());
            m.setFoto(detalles.getFoto());
            m.setNombre_raza(detalles.getNombre_raza()); // Datos de la API
            m.setNombre_especie(detalles.getNombre_especie());
            return repository.save(m);
        }).orElse(null);
    }

    // 3. MÉTODO ELIMINAR (Solo si está Disponible)
    public boolean eliminar(String id) {
        Optional<MascotaAdopcion> mascota = repository.findById(id);
        if (mascota.isPresent() && mascota.get().getEstado().equalsIgnoreCase("Disponible")) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}