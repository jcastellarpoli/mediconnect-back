package com.poli.ips.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonaDTO {

    public int id;

    public String nombres;

    public String apellido;

    public String tipo_documento;

    public int numero_documento;



}
