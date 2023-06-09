package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Klasa;
import com.example.knk_project.models.dto.CreateKlasaDto;
import com.example.knk_project.models.dto.UpdateNotaDto;

import java.sql.SQLException;
import java.util.List;

public interface KlasaRepositoryInterface {
    void insert(CreateKlasaDto createKlasaDto) throws SQLException;

    List<Klasa> getAllKlasat() throws SQLException;
    int getNumberOfKlaseve() throws SQLException;

    List<Klasa> getAllKlasatByProfesorId(int profesoriId) throws SQLException;

    Klasa getKlasaByNxenesiId(int nxenesiId) throws SQLException;

    Klasa getKlasaByKlasaId(int klasaId) throws SQLException;

}
