package com.veterinaria.api.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.veterinaria.api.models.enums.EstadoAdopcion;
import com.veterinaria.api.models.enums.TipoSexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mascota_adopcion")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MascotaAdopcion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty("id_mascota_adopcion")
    private String id_mascota_adopcion;

    @Column(name = "id_raza")
    @JsonProperty("id_raza")
    private String id_raza;

    @Column(name = "id_especie")
    @JsonProperty("id_especie")
    private String id_especie;

    @Column(name = "nombre_raza")
    @JsonProperty("nombre_raza")
    private String nombre_raza;

    @Column(name = "nombre_especie")
    @JsonProperty("nombre_especie")
    private String nombre_especie;

    @JsonProperty("nombre_mascota")
    @Column(name = "nombre_mascota")
    private String nombre_mascota;

    @JsonProperty("sexo")
    @Column(name = "sexo")
    private String sexo;

    @Column(columnDefinition = "TEXT") // Para descripciones largas de la API
    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("contacto")
    private String contacto;

    @JsonProperty("edad_estimada")
    @Column(name = "edad_estimada")
    private String edad_estimada;

    @JsonProperty("estado")
    @Column(name = "estado")
    private String estado = "Disponible";

    @JsonProperty("foto")
    private String foto;
}