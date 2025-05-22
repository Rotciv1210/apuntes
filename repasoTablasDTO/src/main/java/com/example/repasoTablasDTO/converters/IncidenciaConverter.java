package com.example.repasoTablasDTO.converters;

import com.example.repasoTablasDTO.dto.IncidenciaDTO;
import com.example.repasoTablasDTO.model.Incidencias;
import org.springframework.stereotype.Component;

@Component
public class IncidenciaConverter {

    public IncidenciaDTO convertIncidenciaToIncidenciaDTO(Incidencias incidencias){

        IncidenciaDTO incidenciaDTO = new IncidenciaDTO();

        incidenciaDTO.setAula(incidencias.getAula().getNombre());
        incidenciaDTO.setDescripcion(incidencias.getDescripcion());
        incidenciaDTO.setFecha(incidencias.getFecha());

        return incidenciaDTO;
    }
}
