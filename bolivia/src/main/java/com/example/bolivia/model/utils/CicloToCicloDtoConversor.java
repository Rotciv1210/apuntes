package com.example.bolivia.model.utils;

import com.example.bolivia.model.Ciclo;
import com.example.bolivia.model.dtos.CicloDTO;

import java.util.ArrayList;
import java.util.List;

public abstract class CicloToCicloDtoConversor {
    public static CicloDTO convertirCiclo(Ciclo ciclo){
        if(ciclo == null) return null;
        return new CicloDTO(ciclo.getId(), ciclo.getNombre());
    }

    public static List<CicloDTO> convertirCiclos(List<Ciclo> ciclos){
        List<CicloDTO> ciclosDTO = new ArrayList<>();
        for(Ciclo ciclo: ciclos){
            ciclosDTO.add(convertirCiclo(ciclo));
        }
        return ciclosDTO;
    }
}
