package com.poli.ips.repository;

import com.poli.ips.model.dto.CitasDTO;
import com.poli.ips.model.entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {
    @Query(value = "CALL login(:tipo,:numero)", nativeQuery = true)
    String authLog(@Param("tipo") String tipo,@Param("numero") Integer numero);

    @Query(value = "SELECT * FROM persona WHERE tipo_documento=:tipo and numero_documento=:numero", nativeQuery = true)
    Persona findPersonaByDoc(@Param("tipo") String tipo,@Param("numero") Integer numero);

}
