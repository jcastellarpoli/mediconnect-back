package com.poli.ips.repository;


import com.poli.ips.model.dto.CitasDTO;
import com.poli.ips.model.entity.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Cita, Integer> {

    @Query(value = "SELECT * FROM cita WHERE persona_id=:id_persona", nativeQuery = true)
    List<Cita> findCitaByPersona(@Param("id_persona") Integer numero);
}
