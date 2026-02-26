package com.veterinaria.api.repository;

import com.veterinaria.api.models.MascotaAdopcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaAdopcionRepository extends JpaRepository<MascotaAdopcion, String> {
}