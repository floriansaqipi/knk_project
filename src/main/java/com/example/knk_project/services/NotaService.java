package com.example.knk_project.services;

import com.example.knk_project.models.Lenda;
import com.example.knk_project.models.Nota;
import com.example.knk_project.models.Nxenesi;
import com.example.knk_project.models.ProfesoriNotaTableView;
import com.example.knk_project.models.dto.CreateNotaDto;
import com.example.knk_project.models.dto.NotaExistsDto;
import com.example.knk_project.models.dto.UpdateNotaDto;
import com.example.knk_project.repositories.LendaRepository;
import com.example.knk_project.repositories.NotaRepository;
import com.example.knk_project.repositories.NxenesiRepository;
import com.example.knk_project.repositories.interfaces.LendaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.NotaRepositoryInterface;
import com.example.knk_project.repositories.interfaces.NxenesiRepositoryInterface;
import com.example.knk_project.services.exceptions.NotaExistsException;
import com.example.knk_project.services.interfaces.NotaServiceInterface;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NotaService implements NotaServiceInterface {
    private NotaRepositoryInterface notaRepository = new NotaRepository();
    private LendaRepositoryInterface lendaRepository = new LendaRepository();
    private NxenesiRepositoryInterface nxenesiRepository = new NxenesiRepository();
    @Override
    public void insert(CreateNotaDto createNotaDto) throws SQLException, NotaExistsException {
        Nota nota = null;
        NotaExistsDto notaExistsDto = new NotaExistsDto(
                createNotaDto.getGjysmevjetori(),
                createNotaDto.getRubrika(),
                createNotaDto.getNxenesiId(),
                createNotaDto.getLendaId()
        );
        nota = this.notaRepository.getNotaByNotaExists(notaExistsDto);
        if(nota != null){
            throw new NotaExistsException("Nota exists");
        }
        this.notaRepository.insert(createNotaDto);

    }

    @Override
    public List<Nota> getAllNotat() throws SQLException{
        return this.notaRepository.getAllNotat();
    }

    @Override
    public int getNumberOfGrades() throws SQLException {
        return this.notaRepository.getNumberOfGrades();
    }

    @Override
    public void addDataToGradesDataList(ObservableList<ProfesoriNotaTableView> gradesDatalist, int profesoriId) throws SQLException {
        gradesDatalist.clear();
        List<Nota> notatByProfesori = this.notaRepository.getAllNotatByProfesoriId(profesoriId);
        for (Nota nota: notatByProfesori) {
            Lenda lenda = this.lendaRepository.getLendaByLendaId(nota.getLendaId());
            Nxenesi nxenesi = this.nxenesiRepository.getNxenesiByNxenesiId(nota.getNxenesiId());
            gradesDatalist.add(new ProfesoriNotaTableView(nota ,nxenesi, lenda));
        }
    }

    @Override
    public void deleteNotaByNotaId(int notaId) throws SQLException {
        this.notaRepository.deleteNotaByNotaId(notaId);
    }

    @Override
    public int getAverageGrade(int studentiID) throws SQLException {
        return this.notaRepository.getAverageGrade(studentiID);
    }

    @Override
    public void update(UpdateNotaDto updateNotaDto) throws SQLException {
        this.notaRepository.update(updateNotaDto);
    }

}
