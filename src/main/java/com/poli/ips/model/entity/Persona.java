package com.poli.ips.model.entity;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Persona")
@Table(name = "persona")
@Data
public class Persona {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public int id;

    public String nombres;

    public String apellido;

    public String tipo_documento;

    public int numero_documento;


}
