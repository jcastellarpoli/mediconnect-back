package com.poli.ips.service;

import com.poli.ips.model.dto.CitasDTO;
import com.poli.ips.model.dto.DoctorDTO;
import com.poli.ips.model.dto.PersonaDTO;
import com.poli.ips.model.entity.Cita;
import com.poli.ips.model.entity.Doctor;
import com.poli.ips.model.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IIpsService {


    String authLog(String tipo,Integer numero);
    PersonaDTO findPersonaByDoc(String tipo,Integer numero);

    CitasDTO createCitas(Cita cita);

    DoctorDTO createDoctor(Doctor doctor);

    CitasDTO updateCitas(Cita cita);

    PersonaDTO createPersona(Persona persona);

    void deletePersona(Integer id);

    void deleteCita(Integer id);

    List<CitasDTO> findAllCitas();
    List<CitasDTO> findCitasByPaciente(Integer id_persona);

    List<PersonaDTO> findAllPersonas();

    List<DoctorDTO> findAllDoctores();

    CitasDTO findCita(Integer id);

    PersonaDTO findPersona(Integer id);
}
