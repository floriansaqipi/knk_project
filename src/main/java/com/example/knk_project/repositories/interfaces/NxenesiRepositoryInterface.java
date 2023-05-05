package com.example.knk_project.repositories.interfaces;

import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.dto.CreateNxenesiDto;

import java.sql.SQLException;

public interface NxenesiRepositoryInterface {
    public void insert(CreateNxenesiDto createNxenesiDto) throws SQLException;
    public Nxenesi getNxenesiByUsername(String username) throws SQLException;
}
