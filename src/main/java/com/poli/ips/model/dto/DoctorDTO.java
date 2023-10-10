package com.poli.ips.model.dto;

import lombok.Data;

@Data
public class DoctorDTO {

    public int id;

    public String nombres;

    public String apellidos;

    public String especialidad;

    public String tipo_documento;

    public int numero_documento;
}
