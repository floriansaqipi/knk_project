package com.example.knk_project.services.interfaces;

import com.example.knk_project.models.dto.CreateNxenesiDto;
import com.example.knk_project.models.dto.CreatePrindiDto;
import com.example.knk_project.services.exceptions.IncorrectPasswordException;
import com.example.knk_project.services.exceptions.UserAlreadyExistsException;
import com.example.knk_project.services.exceptions.UserNotFoundException;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

public interface NxenesiServiceInterface {
    public void signUp(CreateNxenesiDto createNxenesiDto, CreatePrindiDto createPrindiDto)
            throws SQLException, UserAlreadyExistsException;
    public void logIn(String username, String password) throws
            UserNotFoundException, IncorrectPasswordException,SQLException;
}
