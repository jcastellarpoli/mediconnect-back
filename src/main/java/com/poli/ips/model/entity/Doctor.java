package com.poli.ips.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity(name = "Doctor")
@Table(name = "doctor")
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    public String nombres;

    public String apellidos;

    public String especialidad;

    public String tipo_documento;

    public int numero_documento;
}
