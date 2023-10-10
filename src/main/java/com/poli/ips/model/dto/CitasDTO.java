package com.poli.ips.model.dto;

import lombok.Data;

@Data
public class CitasDTO {

    public int id;

    public int id_doctor;

    public int id_persona;

    public String fecha_hora;

    public String tipo_cita;

    public String estado_cita;
}
