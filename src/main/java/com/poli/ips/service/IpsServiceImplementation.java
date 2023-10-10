package com.poli.ips.service;

import com.poli.ips.model.dto.CitasDTO;
import com.poli.ips.model.dto.DoctorDTO;
import com.poli.ips.model.dto.PersonaDTO;
import com.poli.ips.model.entity.Cita;
import com.poli.ips.model.entity.Doctor;
import com.poli.ips.model.entity.Persona;
import com.poli.ips.repository.CitasRepository;
import com.poli.ips.repository.DoctorRepository;
import com.poli.ips.repository.PersonaRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class IpsServiceImplementation implements IIpsService {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CitasDTO createCitas(Cita cita) {
        /*

         */
        return convertCitasToDTO(citasRepository.save(cita));
    }
    @Override
    public DoctorDTO createDoctor(Doctor doctor) {
        return convertDoctorToDTO(doctorRepository.save(doctor));

    }
    @Override
    public PersonaDTO createPersona(Persona persona) {
        return convertPersonaToDTO(personaRepository.save(persona));
    }
    @Override
    public CitasDTO updateCitas(Cita cita) {
        Cita citaActualizar = citasRepository.findById(cita.getId()).get();
        citasRepository.save(cita);
        return convertCitasToDTO(citasRepository.save(citaActualizar));
    }
    @Override
    public void deletePersona(Integer id) {
        personaRepository.deleteById(id);
    }

    @Override
    public void deleteCita(Integer id) {
        citasRepository.deleteById(id);
    }

    @Override
    public List<CitasDTO> findCitasByPaciente(Integer id_persona) {
        return citasRepository.findCitaByPersona(id_persona).stream()
                .map(this::convertCitasToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CitasDTO> findAllCitas() {
        return citasRepository.findAll().stream()
                .map(this::convertCitasToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PersonaDTO> findAllPersonas() {
        return personaRepository.findAll().stream()
                .map(this::convertPersonaToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<DoctorDTO> findAllDoctores() {
        return doctorRepository.findAll().stream()
                .map(this::convertDoctorToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CitasDTO findCita(Integer id) {
        return convertCitasToDTO(citasRepository.findById(id).get());
    }

    @Override
    public PersonaDTO findPersona(Integer id) {
        if(personaRepository.findById(id).isEmpty()){
            return new PersonaDTO();
        }
        return convertPersonaToDTO(personaRepository.findById(id).get());
    }

    @Override
    public PersonaDTO findPersonaByDoc(String tipo,Integer numero) {
        return convertPersonaToDTO(personaRepository.findPersonaByDoc(tipo,numero));
    }

    @Override
    public String authLog(String tipo_doc,Integer numero) {
        return personaRepository.authLog(tipo_doc,numero);
    }

    private PersonaDTO convertPersonaToDTO(Persona persona) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        PersonaDTO personaDTO = new PersonaDTO();
        personaDTO = modelMapper.map(persona, PersonaDTO.class);
        return personaDTO;
    }

    private Persona convertDTOToPersona(PersonaDTO personaDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Persona persona = new Persona();
        persona = modelMapper.map(personaDTO, Persona.class);
        return persona;
    }

    private DoctorDTO convertDoctorToDTO(Doctor doctor) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        DoctorDTO doctorDTO = new DoctorDTO();

        doctorDTO = modelMapper.map(doctor, DoctorDTO.class);
        return doctorDTO;
    }

    private Doctor convertDTOToDoctor(DoctorDTO doctorDTO) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Doctor doctor = new Doctor();
        doctor = modelMapper.map(doctorDTO, Doctor.class);
        return doctor;
    }

    private CitasDTO convertCitasToDTO(Cita cita) {

        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);

        CitasDTO citasDTO = new CitasDTO();

        citasDTO = modelMapper.map(cita, CitasDTO.class);
        return citasDTO;
    }
}
