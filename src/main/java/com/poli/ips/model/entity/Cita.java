package com.poli.ips.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
@Entity(name = "Cita")
@Table(name = "cita")
@Data
public class Cita {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    public int doctor_id;

    public int persona_id;

    public String fecha_hora;

    public String tipo_cita;

    public String estado_cita;



}
