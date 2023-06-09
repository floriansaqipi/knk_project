package com.example.knk_project.services;

import com.example.knk_project.models.Shteti;
import com.example.knk_project.models.dto.CreateShtetiDto;
import com.example.knk_project.models.dto.UpdateShtetiDto;
import com.example.knk_project.repositories.ShtetiRepository;
import com.example.knk_project.repositories.interfaces.ShtetiRepositoryInterface;
import com.example.knk_project.services.interfaces.ShtetiServiceInterface;

import java.sql.SQLException;
import java.util.List;

public class ShtetiService implements ShtetiServiceInterface {
    private ShtetiRepositoryInterface shtetiRepository = new ShtetiRepository();


    @Override
    public void register(CreateShtetiDto createShtetiDto) throws SQLException {
        this.shtetiRepository.insert(createShtetiDto);
    }

    @Override
    public List<Shteti> getAllShtetet() throws SQLException {
        return this.shtetiRepository.getAllShtetet();
    }

    @Override
    public void deleteShtetiByShtetiId(int shtetiID) throws SQLException {
        this.shtetiRepository.deleteShtetiByShtetiId(shtetiID);
    }

    @Override
    public void update(UpdateShtetiDto updateShtetiDto) throws SQLException {
          this.shtetiRepository.update(updateShtetiDto);
    }
}
